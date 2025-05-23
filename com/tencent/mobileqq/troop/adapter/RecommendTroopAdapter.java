package com.tencent.mobileqq.troop.adapter;

import NearbyGroup.GroupLabel;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.util.ax;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopHeaderLayout;
import com.tencent.mobileqq.troop.utils.ao;
import com.tencent.mobileqq.troop.utils.j;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x935.oidb_0x935$RgroupInfo;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$Label;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class RecommendTroopAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private static final HashMap<Long, Integer> C;
    private static final Comparator<GroupLabel> D;

    /* renamed from: m, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f293757m;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f293758d;

    /* renamed from: e, reason: collision with root package name */
    private Context f293759e;

    /* renamed from: f, reason: collision with root package name */
    private final List<RecommendTroopItem> f293760f;

    /* renamed from: h, reason: collision with root package name */
    private final View.OnClickListener f293761h;

    /* renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f293762i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    if (iArr[0] == 0) {
                        iArr[0] = bitmap.getWidth();
                    }
                    if (iArr[1] == 0) {
                        iArr[1] = bitmap.getHeight();
                    }
                    bitmap = BaseImageUtil.getRoundedCornerBitmap3(bitmap, iArr[2], iArr[0], iArr[1]);
                    if (bitmap == null && QLog.isDevelopLevel()) {
                        QLog.w("RecommendTroop", 2, "ROUND_CORNER_DECODER bitmap == null");
                    }
                }
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendTroopAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                RecommendTroopItem recommendTroopItem = (RecommendTroopItem) view.getTag(-1);
                if (recommendTroopItem.type == 1) {
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildFormSearch(recommendTroopItem.uin, recommendTroopItem.authSig, 246623, null);
                } else {
                    RecommendTroopAdapter.this.s(recommendTroopItem);
                }
                RecommendTroopAdapter.this.t(recommendTroopItem, view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendTroopAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                RecommendTroopItem recommendTroopItem = (RecommendTroopItem) view.getTag(-1);
                if (recommendTroopItem.type == 1) {
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildFormSearch(recommendTroopItem.uin, recommendTroopItem.authSig, 246623, null);
                } else {
                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openRecommendTroop(RecommendTroopAdapter.this.f293759e, recommendTroopItem, RecommendTroopAdapter.this.o(), RecommendTroopAdapter.this.p());
                    RecommendTroopAdapter.this.r(recommendTroopItem);
                }
                RecommendTroopAdapter.this.t(recommendTroopItem, view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements Comparator<GroupLabel> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(GroupLabel groupLabel, GroupLabel groupLabel2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupLabel, (Object) groupLabel2)).intValue();
            }
            return RecommendTroopAdapter.n(Long.valueOf(groupLabel2.type)) - RecommendTroopAdapter.n(Long.valueOf(groupLabel.type));
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public View f293768a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f293769b;

        /* renamed from: c, reason: collision with root package name */
        public SingleLineTextView f293770c;

        /* renamed from: d, reason: collision with root package name */
        public Button f293771d;

        /* renamed from: e, reason: collision with root package name */
        public TroopActiveLayout f293772e;

        /* renamed from: f, reason: collision with root package name */
        public TroopLabelLayout f293773f;

        /* renamed from: g, reason: collision with root package name */
        public FolderTextView f293774g;

        /* renamed from: h, reason: collision with root package name */
        public TextView f293775h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f293776i;

        /* renamed from: j, reason: collision with root package name */
        public int f293777j;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        f293757m = new a();
        C = new HashMap<Long, Integer>() { // from class: com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                put(21L, 4);
                put(22L, 3);
                put(23L, 2);
                put(20L, 1);
            }
        };
        D = new d();
    }

    public RecommendTroopAdapter(Context context, AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, Boolean.valueOf(z16));
            return;
        }
        this.f293760f = new ArrayList();
        this.f293761h = new b();
        this.f293762i = new c();
        this.f293758d = appInterface;
        this.f293759e = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0360  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(e eVar, RecommendTroopItem recommendTroopItem, Drawable drawable, AppInterface appInterface) {
        List<guildSearchRecommendSvr$Label> list;
        boolean z16 = true;
        if (eVar != null && recommendTroopItem != null) {
            eVar.f293769b.setImageDrawable(drawable);
            eVar.f293770c.setText(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(recommendTroopItem.name, 16));
            eVar.f293770c.setContentDescription(recommendTroopItem.name);
            if (recommendTroopItem.activity > 0) {
                eVar.f293772e.setVisibility(0);
                eVar.f293772e.setHotLevel(recommendTroopItem.activity);
            } else {
                eVar.f293772e.setVisibility(8);
                eVar.f293773f.setMaxLabelCount(4);
            }
            if (recommendTroopItem.type == 1 && ao.b().f().booleanValue() && (list = recommendTroopItem.labels) != null && list.size() > 0) {
                eVar.f293770c.setVisibility(8);
                eVar.f293773f.setVisibility(8);
                TextView textView = (TextView) eVar.f293768a.findViewById(R.id.w0c);
                TextView textView2 = (TextView) eVar.f293768a.findViewById(R.id.vf8);
                TextView textView3 = (TextView) eVar.f293768a.findViewById(R.id.xpj);
                textView.setVisibility(8);
                textView3.setVisibility(8);
                textView2.setVisibility(8);
                ArrayList arrayList = new ArrayList();
                for (guildSearchRecommendSvr$Label guildsearchrecommendsvr_label : recommendTroopItem.labels) {
                    if (guildsearchrecommendsvr_label.label_type.get() == ao.f302040g) {
                        textView3.setVisibility(0);
                        ao.b().g(textView3, guildsearchrecommendsvr_label.bytes_name.get().toStringUtf8());
                    }
                    if (guildsearchrecommendsvr_label.label_type.get() == ao.f302041h) {
                        textView2.setVisibility(0);
                        String stringUtf8 = guildsearchrecommendsvr_label.bytes_name.get().toStringUtf8();
                        if (guildsearchrecommendsvr_label.label_attr.get() == 2) {
                            ao.b().i(textView2, stringUtf8);
                        } else {
                            ao.b().g(textView2, stringUtf8);
                        }
                    }
                    if (guildsearchrecommendsvr_label.label_type.get() == ao.f302042i && !TextUtils.isEmpty(guildsearchrecommendsvr_label.label_value.get())) {
                        textView.setVisibility(0);
                        textView.setText(guildsearchrecommendsvr_label.bytes_name.get().toStringUtf8());
                        URLDrawable drawable2 = URLDrawable.getDrawable(guildsearchrecommendsvr_label.label_value.get(), (URLDrawable.URLDrawableOptions) null);
                        drawable2.setBounds(0, 0, ViewUtils.dpToPx(15.0f), ViewUtils.dpToPx(15.0f));
                        textView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0f));
                        textView.setCompoundDrawables(drawable2, null, null, null);
                    }
                    if (guildsearchrecommendsvr_label.label_type.get() == ao.f302043j && !TextUtils.isEmpty(guildsearchrecommendsvr_label.label_value.get())) {
                        arrayList.add(guildsearchrecommendsvr_label.label_value.get());
                    }
                }
                TextView textView4 = (TextView) eVar.f293768a.findViewById(R.id.wrw);
                textView4.setText(recommendTroopItem.name.trim());
                if (arrayList.size() > 0) {
                    textView4.post(new Runnable(textView4, recommendTroopItem, arrayList) { // from class: com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter.4
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TextView f293763d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ RecommendTroopItem f293764e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ List f293765f;

                        {
                            this.f293763d = textView4;
                            this.f293764e = recommendTroopItem;
                            this.f293765f = arrayList;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, textView4, recommendTroopItem, arrayList);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            this.f293763d.setText(ao.b().c(ao.b().a(this.f293763d, this.f293764e.name.trim(), (ao.f302046m + ao.f302045l) * 3), this.f293765f, this.f293763d));
                        }
                    });
                }
            } else {
                eVar.f293770c.setVisibility(0);
                ArrayList<GroupLabel> w3 = w(recommendTroopItem);
                if (w3 != null && w3.size() > 0) {
                    eVar.f293773f.setVisibility(0);
                    eVar.f293773f.setLabelType(1);
                    eVar.f293773f.setAutoCreateDistanceTextView(true);
                    eVar.f293773f.setIsInCompleteDrawOutSide(true);
                    eVar.f293773f.g(w3);
                } else {
                    eVar.f293773f.setVisibility(8);
                }
            }
            if (!recommendTroopItem.isJoined() && !recommendTroopItem.hasRequestJoin) {
                eVar.f293771d.setEnabled(true);
                Button button = eVar.f293771d;
                button.setTextColor(button.getResources().getColorStateList(R.color.qui_common_text_primary));
                if (recommendTroopItem.type == 1) {
                    eVar.f293771d.setText(R.string.f199544pp);
                } else {
                    eVar.f293771d.setText(R.string.fvi);
                }
                if (SimpleUIUtil.isNowElderMode()) {
                    eVar.f293771d.setMinWidth(ViewUtils.dip2px(44.0f));
                    eVar.f293771d.setMinHeight(ViewUtils.dip2px(44.0f));
                    eVar.f293771d.setTextSize(1, 18.0f);
                }
            } else {
                eVar.f293771d.setEnabled(false);
                Button button2 = eVar.f293771d;
                button2.setTextColor(button2.getResources().getColorStateList(R.color.qui_common_text_secondary));
                if (recommendTroopItem.hasRequestJoin) {
                    eVar.f293771d.setText(R.string.fvj);
                } else {
                    eVar.f293771d.setText(R.string.fvk);
                }
            }
            if (TextUtils.isEmpty(recommendTroopItem.intro)) {
                eVar.f293774g.setText("");
                if (com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
                    eVar.f293774g.setVisibility(8);
                }
            } else {
                eVar.f293774g.setText(new QQText(recommendTroopItem.intro, 11, 16));
                eVar.f293774g.setVisibility(0);
            }
            eVar.f293771d.setTag(-1, recommendTroopItem);
            eVar.f293775h.setTag(-1, recommendTroopItem);
            eVar.f293768a.setTag(-1, recommendTroopItem);
            if (recommendTroopItem.type == 0) {
                com.tencent.mobileqq.troop.adapter.c.d(recommendTroopItem, (TroopHeaderLayout) eVar.f293768a.findViewById(R.id.wip), (ImageView) eVar.f293768a.findViewById(R.id.x1c), (ImageView) eVar.f293768a.findViewById(R.id.x1d));
            }
            if (recommendTroopItem.type == 1) {
                e(eVar.f293768a, recommendTroopItem);
            }
            if (com.tencent.mobileqq.troop.exp.a.f295373a.c() && eVar.f293776i != null) {
                if (recommendTroopItem.labelList.size() > 0) {
                    for (oidb_0x9fb$Label oidb_0x9fb_label : recommendTroopItem.labelList) {
                        if (oidb_0x9fb_label.uint32_label_type.get() == 300) {
                            eVar.f293776i.setText(oidb_0x9fb_label.bytes_name.get().toStringUtf8());
                            ColorDrawable colorDrawable = new ColorDrawable(eVar.f293776i.getContext().getColor(R.color.cac));
                            if (ThemeUtil.isNowThemeIsNight(appInterface, false, null)) {
                                colorDrawable.setAlpha(63);
                            } else {
                                colorDrawable.setAlpha(25);
                            }
                            eVar.f293776i.setBackground(colorDrawable);
                            if (!TextUtils.isEmpty(recommendTroopItem.gameGradeIcon)) {
                                Drawable k3 = k(eVar.f293776i.getContext(), recommendTroopItem.gameGradeIcon);
                                int c16 = x.c(eVar.f293776i.getContext(), 10.0f);
                                k3.setBounds(0, 0, c16, c16);
                                TextView textView5 = eVar.f293776i;
                                textView5.setCompoundDrawablePadding(x.c(textView5.getContext(), 2.0f));
                                eVar.f293776i.setCompoundDrawables(k3, null, null, null);
                            }
                            if (!z16) {
                                eVar.f293776i.setVisibility(0);
                                return;
                            } else {
                                eVar.f293776i.setVisibility(8);
                                return;
                            }
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
        } else {
            QLog.d("RecommendTroop", 1, "viewHolder == null || troopItem == null");
        }
    }

    private static void e(View view, RecommendTroopItem recommendTroopItem) {
        if (ao.b().f().booleanValue()) {
            ax.a((ImageView) view.findViewById(R.id.x1c), com.tencent.mobileqq.troop.adapter.d.a(recommendTroopItem), true);
        } else {
            com.tencent.mobileqq.troop.adapter.c.c(recommendTroopItem, (ImageView) view.findViewById(R.id.x1c), (ImageView) view.findViewById(R.id.x1d));
            com.tencent.mobileqq.troop.adapter.c.a(recommendTroopItem, (ImageView) view.findViewById(R.id.w1j));
            com.tencent.mobileqq.troop.adapter.c.b(recommendTroopItem, (ImageView) view.findViewById(R.id.w1h), (ImageView) view.findViewById(R.id.w1i));
        }
    }

    public static View f(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, int i3) {
        int i16;
        View inflate;
        if (i3 == 1) {
            if (ao.b().f().booleanValue()) {
                inflate = LayoutInflater.from(context).inflate(R.layout.h6f, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.h6d, (ViewGroup) null);
            }
        } else {
            if (com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
                i16 = R.layout.h6e;
            } else {
                i16 = R.layout.cc7;
            }
            inflate = LayoutInflater.from(context).inflate(i16, (ViewGroup) null);
        }
        e eVar = new e();
        eVar.f293777j = i3;
        eVar.f293768a = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.lol);
        eVar.f293769b = imageView;
        if (imageView instanceof ThemeImageView) {
            ((ThemeImageView) imageView).setSupportMaskView(false);
        }
        eVar.f293770c = (SingleLineTextView) inflate.findViewById(R.id.meg);
        eVar.f293771d = (Button) inflate.findViewById(R.id.lax);
        eVar.f293772e = (TroopActiveLayout) inflate.findViewById(R.id.l_v);
        eVar.f293773f = (TroopLabelLayout) inflate.findViewById(R.id.l_w);
        eVar.f293774g = (FolderTextView) inflate.findViewById(R.id.f167042k73);
        eVar.f293775h = (TextView) inflate.findViewById(R.id.mc9);
        eVar.f293776i = (TextView) inflate.findViewById(R.id.vjb);
        eVar.f293771d.setOnClickListener(onClickListener2);
        eVar.f293771d.setPadding(0, 0, 0, 0);
        inflate.setOnClickListener(onClickListener);
        inflate.setTag(eVar);
        if (onClickListener3 != null) {
            eVar.f293775h.setOnClickListener(onClickListener3);
            eVar.f293775h.setVisibility(0);
            inflate.setTag(-3, Integer.valueOf(ViewUtils.dip2px(100.0f)));
        } else {
            eVar.f293775h.setOnClickListener(null);
            eVar.f293775h.setVisibility(8);
            inflate.setTag(-3, null);
        }
        return inflate;
    }

    public static Map<String, Object> h(int i3, @NonNull RecommendTroopItem recommendTroopItem) {
        String str;
        List<guildSearchRecommendSvr$Label> list;
        HashMap hashMap = new HashMap();
        hashMap.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181096h, Integer.valueOf(i3));
        String str2 = com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181097i;
        if (recommendTroopItem.type == 1) {
            str = WadlProxyConsts.CHANNEL;
        } else {
            str = VipFunCallConstants.KEY_GROUP;
        }
        hashMap.put(str2, str);
        hashMap.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181099k, Integer.valueOf(com.tencent.mobileqq.troop.adapter.d.a(recommendTroopItem)));
        hashMap.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181100l, recommendTroopItem.uin);
        hashMap.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181103o, recommendTroopItem.name);
        StringBuilder sb5 = new StringBuilder();
        if (recommendTroopItem.labelList != null) {
            int i16 = 0;
            if (recommendTroopItem.type == 1 && ao.b().f().booleanValue() && (list = recommendTroopItem.labels) != null && list.size() > 0) {
                while (i16 < recommendTroopItem.labels.size()) {
                    sb5.append(recommendTroopItem.labels.get(i16).bytes_name.get().toStringUtf8());
                    if (i16 != recommendTroopItem.labels.size() - 1) {
                        sb5.append(";");
                    }
                    i16++;
                }
            } else {
                while (i16 < recommendTroopItem.labelList.size()) {
                    sb5.append(recommendTroopItem.labelList.get(i16).bytes_name.get().toStringUtf8());
                    if (i16 != recommendTroopItem.labelList.size() - 1) {
                        sb5.append(";");
                    }
                    i16++;
                }
            }
        }
        hashMap.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181098j, sb5.toString());
        return hashMap;
    }

    public static Drawable k(Context context, String str) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int c16 = x.c(context, 10.0f);
        obtain.mRequestWidth = c16;
        obtain.mRequestHeight = c16;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        if (URLUtil.isValidUrl(str)) {
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            drawable.setTag(new int[]{c16, c16, x.c(context, 6.0f)});
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
            return drawable;
        }
        return colorDrawable;
    }

    private Drawable l(String str) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int c16 = x.c(this.f293759e, 58.0f);
        obtain.mRequestWidth = c16;
        obtain.mRequestHeight = c16;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        if (URLUtil.isValidUrl(str)) {
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            drawable.setTag(new int[]{c16, c16, x.c(this.f293759e, 6.0f)});
            drawable.setDecodeHandler(f293757m);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
            return drawable;
        }
        return colorDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(Long l3) {
        HashMap<Long, Integer> hashMap = C;
        if (hashMap.containsKey(l3)) {
            return hashMap.get(l3).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(@NonNull RecommendTroopItem recommendTroopItem, View view) {
        int i3 = 0;
        for (int i16 = 0; i16 < this.f293760f.size(); i16++) {
            if (recommendTroopItem.uin.equals(this.f293760f.get(i16).uin)) {
                i3 = i16;
            }
        }
        Map<String, Object> j3 = j(i3 + 1, recommendTroopItem);
        j3.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181102n, ao.b().d());
        VideoReport.setElementParams(view, j3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void u(View view, int i3, RecommendTroopItem recommendTroopItem, e eVar) {
        if (view != null && recommendTroopItem != null && eVar != null) {
            Map<String, Object> j3 = j(i3 + 1, recommendTroopItem);
            j3.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181102n, ao.b().d());
            Map<String, String> a16 = j.a(recommendTroopItem.recommendTrace);
            j3.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181106r, a16.get("rrid"));
            j3.put(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181107s, a16.get("trace_id"));
            VideoReport.setElementId(view, com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181093e);
            VideoReport.setElementParams(view, j3);
            VideoReport.setElementId(eVar.f293771d, com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181094f);
            VideoReport.setElementParams(eVar.f293771d, j3);
        }
    }

    public static ArrayList<GroupLabel> w(RecommendTroopItem recommendTroopItem) {
        ArrayList<GroupLabel> arrayList = null;
        if (recommendTroopItem == null) {
            return null;
        }
        if (recommendTroopItem.labelList == null && recommendTroopItem.x935RgroupInfo != null) {
            oidb_0x935$RgroupInfo oidb_0x935_rgroupinfo = new oidb_0x935$RgroupInfo();
            try {
                oidb_0x935_rgroupinfo.mergeFrom(recommendTroopItem.x935RgroupInfo);
                if (oidb_0x935_rgroupinfo.rpt_group_label.has()) {
                    recommendTroopItem.labelList = j.b(oidb_0x935_rgroupinfo.rpt_group_label.get());
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
        List<oidb_0x9fb$Label> list = recommendTroopItem.labelList;
        if (list == null) {
            return null;
        }
        if (list.size() > 0) {
            arrayList = new ArrayList<>();
            for (oidb_0x9fb$Label oidb_0x9fb_label : recommendTroopItem.labelList) {
                GroupLabel groupLabel = new GroupLabel();
                NearbyGroup.Color color = new NearbyGroup.Color();
                color.R = oidb_0x9fb_label.edging_color.uint32_r.get();
                color.G = oidb_0x9fb_label.edging_color.uint32_g.get();
                color.B = oidb_0x9fb_label.edging_color.uint32_b.get();
                groupLabel.edging_color = color;
                NearbyGroup.Color color2 = new NearbyGroup.Color();
                color2.R = oidb_0x9fb_label.text_color.uint32_r.get();
                color2.G = oidb_0x9fb_label.text_color.uint32_g.get();
                color2.B = oidb_0x9fb_label.text_color.uint32_b.get();
                groupLabel.text_color = color2;
                groupLabel.strWording = oidb_0x9fb_label.bytes_name.get().toStringUtf8();
                groupLabel.type = oidb_0x9fb_label.uint32_label_type.get();
                if (recommendTroopItem.type == 1) {
                    groupLabel.type = oidb_0x9fb_label.enum_type.get();
                }
                if (oidb_0x9fb_label.get().uint32_label_type.get() != 104) {
                    arrayList.add(groupLabel);
                }
            }
            if (recommendTroopItem.type == 1) {
                try {
                    Collections.sort(arrayList, D);
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public AppInterface g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f293758d;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f293760f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        Drawable faceDrawable;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            RecommendTroopItem item = getItem(i3);
            if (view == null || !(view.getTag() instanceof e) || ((e) view.getTag()).f293777j != item.type) {
                view = f(this.f293759e, this.f293762i, this.f293761h, null, item.type);
            }
            e eVar = (e) view.getTag();
            if (item.type == 1) {
                faceDrawable = l(item.icon);
            } else {
                faceDrawable = FaceDrawable.getFaceDrawable(this.f293758d, 4, item.uin);
            }
            d(eVar, item, faceDrawable, this.f293758d);
            q(item);
            u(view, i3, item, eVar);
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public Context i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f293759e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> j(int i3, @NonNull RecommendTroopItem recommendTroopItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) recommendTroopItem);
        }
        return h(i3, recommendTroopItem);
    }

    @Override // android.widget.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public RecommendTroopItem getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RecommendTroopItem) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return this.f293760f.get(i3);
    }

    protected abstract int o();

    protected abstract int p();

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(RecommendTroopItem recommendTroopItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) recommendTroopItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(RecommendTroopItem recommendTroopItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) recommendTroopItem);
        }
    }

    protected abstract void s(RecommendTroopItem recommendTroopItem);

    public void v(List<RecommendTroopItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else if (list != null) {
            this.f293760f.clear();
            this.f293760f.addAll(list);
        }
    }

    public void x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && this.f293760f.size() > 0) {
            for (RecommendTroopItem recommendTroopItem : this.f293760f) {
                if (str.equals(recommendTroopItem.uin)) {
                    recommendTroopItem.hasRequestJoin = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("RecommendTroop", 2, "updateJoinStatus, troopUin: " + str);
                    }
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public void y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && this.f293760f.size() > 0) {
            for (RecommendTroopItem recommendTroopItem : this.f293760f) {
                if (str.equals(recommendTroopItem.uin)) {
                    recommendTroopItem.privilege = 0;
                    if (QLog.isColorLevel()) {
                        QLog.d("RecommendTroop", 2, "updateJoined, troopUin: " + str);
                    }
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
