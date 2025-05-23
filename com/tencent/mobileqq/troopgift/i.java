package com.tencent.mobileqq.troopgift;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.aio.event.NTPanelEntrance;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.mobileqq.together.ui.TogetherPopupDialog;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.troopgift.i;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.helper.TroopBirthGiftHelper;
import com.tencent.qqnt.aio.helper.ee;
import com.tencent.trpcprotocol.qqva.va_group_gift.service.GroupGiftBirth$UserBirth;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tr2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i extends RecyclerView.Adapter<c> {
    static IPatchRedirector $redirector_;
    private final Activity C;
    private b.h D;
    private String E;
    List<GroupGiftBirth$UserBirth> F;
    private QQAppInterface G;

    /* renamed from: m, reason: collision with root package name */
    private final TogetherPopupDialog f302861m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(GroupGiftBirth$UserBirth groupGiftBirth$UserBirth, TroopMemberInfo troopMemberInfo) {
            Intent intent = new Intent();
            intent.putExtra("member_uin", groupGiftBirth$UserBirth.uid.get());
            if (troopMemberInfo == null) {
                QLog.e("TroopBirthGiftAdapter", 1, "resetReceiver out of troop, memberId:" + groupGiftBirth$UserBirth.uid.get());
                intent.putExtra("member_display_name", groupGiftBirth$UserBirth.uid.get());
            } else {
                intent.putExtra("member_display_name", troopMemberInfo.friendnick);
            }
            ee.INSTANCE.e(i.this.C, i.this.E, intent, NTPanelEntrance.TROOP_BIRTH_BANNER);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                i.this.f302861m.dismiss();
                if (i.this.F.size() == 1) {
                    final GroupGiftBirth$UserBirth next = i.this.F.iterator().next();
                    ((ITroopMemberInfoService) i.this.G.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(i.this.E, next.uid.get(), "TroopBirthGiftAdapter", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troopgift.h
                        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                        public final void a(TroopMemberInfo troopMemberInfo) {
                            i.a.this.b(next, troopMemberInfo);
                        }
                    });
                } else if (i.this.F.size() > 1) {
                    new e(i.this.C, i.this.E).w();
                }
                TroopBirthGiftHelper.INSTANCE.p("18", "birthday", "", "1", 102, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                b.h hVar = (b.h) view.getTag();
                if (hVar != null) {
                    if ("1".equals(hVar.f437167a) && !TextUtils.isEmpty(hVar.f437168b)) {
                        Intent intent = new Intent(i.this.C, (Class<?>) QQBrowserDelegationActivity.class);
                        intent.putExtra("url", hVar.f437168b);
                        intent.putExtra("fromOneCLickCLose", true);
                        i.this.C.startActivity(intent);
                    } else if ("2".equals(hVar.f437167a) && !TextUtils.isEmpty(hVar.f437168b)) {
                        Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                        intent2.setData(Uri.parse(hVar.f437168b));
                        i.this.C.startActivity(intent2);
                    } else if ("3".equals(hVar.f437167a) && !TextUtils.isEmpty(hVar.f437168b)) {
                        i.this.f302861m.p(hVar.f437168b);
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("op_via", "3");
                    i.this.f302861m.g(hashMap);
                    ClockReportUtil.a("click#aio_front_panel", hashMap);
                    TroopBirthGiftHelper.INSTANCE.p("18", "watch", "", "1", 102, null);
                    tr2.b.q(i.this.G).M(i.this.G.getCurrentUin(), 102, hVar.f437170d.iAdId.get() + "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        RoundRectUrlImageView E;
        TextView F;
        ViewGroup G;
        LinearLayout H;
        ImageView I;
        TextView J;
        TextView K;
        ImageView L;
        TextView M;

        public c(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.E = (RoundRectUrlImageView) view.findViewById(R.id.l_u);
            this.G = (ViewGroup) view.findViewById(R.id.f85524p7);
            this.I = (ImageView) view.findViewById(R.id.t85);
            this.J = (TextView) view.findViewById(R.id.t87);
            this.K = (TextView) view.findViewById(R.id.t86);
            this.L = (ImageView) view.findViewById(R.id.t7y);
            this.F = (TextView) view.findViewById(R.id.u9y);
            Typeface createFromAsset = Typeface.createFromAsset(view.getContext().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
            if (createFromAsset != null) {
                this.F.setTypeface(createFromAsset);
            }
            this.M = (TextView) view.findViewById(R.id.zgd);
            this.H = (LinearLayout) view.findViewById(R.id.zi6);
        }
    }

    public i(TogetherPopupDialog togetherPopupDialog, Activity activity, List<GroupGiftBirth$UserBirth> list, b.h hVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, togetherPopupDialog, activity, list, hVar, str);
            return;
        }
        this.F = new ArrayList();
        this.G = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.C = activity;
        this.E = str;
        this.F = list;
        this.D = hVar;
        this.f302861m = togetherPopupDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(String str, c cVar, TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo == null) {
            QLog.e("TroopBirthGiftAdapter", 1, "troopMemberInfo null, memberId:" + str);
            cVar.J.setText(str);
            return;
        }
        cVar.J.setText(troopMemberInfo.friendnick);
    }

    private void o0(@NonNull c cVar) {
        cVar.F.setVisibility(8);
        cVar.L.setVisibility(8);
        cVar.M.setVisibility(8);
        cVar.H.setVisibility(8);
        cVar.G.setVisibility(8);
        if (this.D != null) {
            URLDrawable drawable = URLDrawable.getDrawable(this.D.f437169c, URLDrawable.URLDrawableOptions.obtain());
            cVar.E.setAllRadius(ViewUtils.dpToPx(16.0f));
            cVar.E.setImageDrawable(drawable);
            cVar.E.setVisibility(0);
            cVar.E.setEnableEffect(true);
            cVar.E.setTag(this.D);
            cVar.E.setOnClickListener(new b());
            if (AppSetting.f99565y) {
                cVar.E.setContentDescription(this.C.getString(R.string.f171209d55));
            }
            TroopBirthGiftHelper.INSTANCE.p("18", "watch", "", "1", 101, null);
            tr2.b.q(this.G).M(this.G.getCurrentUin(), 101, this.D.f437170d.iAdId.get() + "");
        }
    }

    private void r0(@NonNull c cVar) {
        cVar.H.setVisibility(0);
        cVar.G.setVisibility(8);
        for (int i3 = 0; i3 < Math.min(5, this.F.size()); i3++) {
            GroupGiftBirth$UserBirth groupGiftBirth$UserBirth = this.F.get(i3);
            ImageView imageView = new ImageView(this.C);
            imageView.setBackground(ResourcesCompat.getDrawable(this.C.getResources(), R.drawable.cac, null));
            FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.G, 1, groupGiftBirth$UserBirth.uid.get());
            if (i3 == 4 && this.F.size() > 5) {
                try {
                    imageView.setImageDrawable(new LayerDrawable(new Drawable[]{faceDrawable, ResourcesCompat.getDrawable(this.C.getResources(), R.drawable.lvt, null)}));
                } catch (Exception e16) {
                    QLog.e("TroopBirthGiftAdapter", 1, "layerDrawable error:" + e16);
                    imageView.setImageDrawable(faceDrawable);
                }
            } else {
                imageView.setImageDrawable(faceDrawable);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(44.0f), ViewUtils.dpToPx(44.0f));
            if (i3 > 0) {
                layoutParams.setMargins(-ViewUtils.dpToPx(22.0f), 0, 0, 0);
            }
            imageView.setLayoutParams(layoutParams);
            imageView.setPadding(ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(2.0f));
            cVar.H.addView(imageView);
        }
        cVar.F.setText(String.valueOf(this.F.size()));
    }

    private void s0(@NonNull final c cVar) {
        cVar.G.setVisibility(0);
        cVar.H.setVisibility(8);
        cVar.F.setText("1");
        if (this.F.size() == 0) {
            VasLogReporter.getBirthGift().report("birthList is null");
            return;
        }
        final String str = this.F.iterator().next().uid.get();
        long j3 = this.F.iterator().next().time.get();
        new Date().setTime(j3);
        cVar.I.setImageDrawable(FaceDrawable.getFaceDrawable(this.G, 1, str));
        cVar.K.setText(TroopBirthGiftHelper.INSTANCE.g(j3 * 1000, this.C));
        ((ITroopMemberInfoService) this.G.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(this.E, str, "TroopBirthGiftAdapter", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troopgift.g
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
            public final void a(TroopMemberInfo troopMemberInfo) {
                i.n0(str, cVar, troopMemberInfo);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (!this.F.isEmpty() && this.D != null) {
            return 2;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar, i3);
            return;
        }
        if (this.F.isEmpty()) {
            o0(cVar);
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                o0(cVar);
                return;
            }
            return;
        }
        cVar.E.setImageDrawable(URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/vas_groupgift_bannerbg.png"));
        cVar.F.setVisibility(0);
        cVar.L.setVisibility(0);
        cVar.M.setVisibility(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.dip2px(82.0f);
        obtain.mRequestHeight = ViewUtils.dip2px(30.0f);
        cVar.L.setImageDrawable(URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/vas_groupgift_bannertitle.png", obtain));
        Iterator<GroupGiftBirth$UserBirth> it = this.F.iterator();
        String currentAccountUin = this.G.getCurrentAccountUin();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (TextUtils.equals(String.valueOf(it.next().get().uid.get()), currentAccountUin)) {
                it.remove();
                break;
            }
        }
        if (this.F.size() <= 1) {
            s0(cVar);
        } else {
            r0(cVar);
        }
        TroopBirthGiftHelper.INSTANCE.p("18", "birthday", "", "1", 101, null);
        cVar.E.setOnClickListener(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gzu, viewGroup, false));
    }
}
