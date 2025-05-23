package com.tencent.mobileqq.panel;

import QC.AioBubbleRecom$GetAioRecommendRsp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.panel.bubble.FontBubbleEventReceiver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes16.dex */
public class FontBubblePanelView<T> extends RichTextPanelView implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static boolean[] K;
    private FontBubbleManager C;
    private com.tencent.aio.api.runtime.a D;
    private RichTextPanelRecyclerView E;
    private FontBubblePanelView<T>.d F;
    private Drawable G;
    private com.tencent.mobileqq.panel.f H;
    private FontBubbleEventReceiver I;
    private SVIPObserver J;

    /* renamed from: f, reason: collision with root package name */
    private int f257126f;

    /* renamed from: h, reason: collision with root package name */
    private long f257127h;

    /* renamed from: i, reason: collision with root package name */
    private List<FontBubble> f257128i;

    /* renamed from: m, reason: collision with root package name */
    private c<T> f257129m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements QueryTask.a<T, List<FontBubble>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontBubblePanelView.this);
            }
        }

        @Override // com.tencent.mobileqq.model.QueryTask.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<FontBubble> query(T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
            }
            try {
                List<FontBubble> c16 = FontBubblePanelView.this.f257129m.c((QQAppInterface) FontBubblePanelView.this.f257150d, t16);
                FontBubble fontBubble = new FontBubble();
                fontBubble.viewType = 0;
                c16.add(fontBubble);
                return c16;
            } catch (Exception e16) {
                QLog.e("AIOFontBubble_FontBubblePanelView", 1, "query: ", e16);
                return new ArrayList();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements QueryCallback<List<FontBubble>> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontBubblePanelView.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.api.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(List<FontBubble> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FontBubblePanelView.this.f257128i = list;
                FontBubblePanelView.this.F.notifyDataSetChanged();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface c<T> {
        String b(Context context);

        List<FontBubble> c(QQAppInterface qQAppInterface, T t16);

        void d(ISVIPHandler iSVIPHandler);

        String e(FontBubble fontBubble);

        int getType();
    }

    /* loaded from: classes16.dex */
    public class d extends RecyclerView.Adapter<FontBubblePanelView<T>.e> {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontBubblePanelView.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return FontBubblePanelView.this.f257128i.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            return ((FontBubble) FontBubblePanelView.this.f257128i.get(i3)).viewType;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(FontBubblePanelView<T>.e eVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar, i3);
            } else if (i3 < FontBubblePanelView.this.f257128i.size()) {
                FontBubblePanelView fontBubblePanelView = FontBubblePanelView.this;
                fontBubblePanelView.u(eVar, (FontBubble) fontBubblePanelView.f257128i.get(i3));
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(eVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public FontBubblePanelView<T>.e onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            return new e(LayoutInflater.from(FontBubblePanelView.this.getContext()).inflate(R.layout.c3b, viewGroup, false));
        }
    }

    /* loaded from: classes16.dex */
    public class e extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f257133d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f257134e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f257135f;

        /* renamed from: h, reason: collision with root package name */
        public TextView f257136h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f257137i;

        public e(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontBubblePanelView.this, (Object) view);
                return;
            }
            this.f257135f = (ImageView) view.findViewById(R.id.vd8);
            this.f257134e = (ImageView) view.findViewById(R.id.vd9);
            this.f257133d = (ImageView) view.findViewById(R.id.ci9);
            this.f257136h = (TextView) view.findViewById(R.id.f5e);
            this.f257137i = (ImageView) view.findViewById(R.id.f167073kg2);
        }
    }

    /* loaded from: classes16.dex */
    private static class f extends SVIPObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<FontBubblePanelView> f257139d;

        public f(FontBubblePanelView fontBubblePanelView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fontBubblePanelView);
            } else {
                this.f257139d = new WeakReference<>(fontBubblePanelView);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onGetBubbleRecommend(boolean z16, AioBubbleRecom$GetAioRecommendRsp aioBubbleRecom$GetAioRecommendRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aioBubbleRecom$GetAioRecommendRsp);
                return;
            }
            if (aioBubbleRecom$GetAioRecommendRsp == null) {
                QLog.e("AIOFontBubble_FontBubblePanelView", 1, "onGetBubbleRecommend data = null");
                return;
            }
            FontBubblePanelView fontBubblePanelView = this.f257139d.get();
            if (fontBubblePanelView == null) {
                QLog.e("AIOFontBubble_FontBubblePanelView", 1, "onGetBubbleRecommend ref is null");
                return;
            }
            if (fontBubblePanelView.f257126f == 4) {
                QLog.i("AIOFontBubble_FontBubblePanelView", 1, "onGetBubbleRecommendList isSuccess = " + z16 + " size = " + aioBubbleRecom$GetAioRecommendRsp.items.size());
                if (z16 && aioBubbleRecom$GetAioRecommendRsp.items.size() > 0) {
                    fontBubblePanelView.C.x(aioBubbleRecom$GetAioRecommendRsp.ruleId.get());
                    fontBubblePanelView.r(aioBubbleRecom$GetAioRecommendRsp);
                } else {
                    QLog.e("AIOFontBubble_FontBubblePanelView", 1, "onGetBubbleRecommend failed, size:" + aioBubbleRecom$GetAioRecommendRsp.items.size());
                }
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onGetFontRecommend(boolean z16, AioBubbleRecom$GetAioRecommendRsp aioBubbleRecom$GetAioRecommendRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aioBubbleRecom$GetAioRecommendRsp);
                return;
            }
            if (aioBubbleRecom$GetAioRecommendRsp == null) {
                QLog.e("AIOFontBubble_FontBubblePanelView", 1, "onGetFontRecommend data = null");
                return;
            }
            FontBubblePanelView fontBubblePanelView = this.f257139d.get();
            if (fontBubblePanelView == null) {
                QLog.e("AIOFontBubble_FontBubblePanelView", 1, "onGetBubbleRecommend ref is null");
                return;
            }
            if (fontBubblePanelView.f257126f == 3) {
                QLog.i("AIOFontBubble_FontBubblePanelView", 1, "onGetFontRecommend isSuccess = " + z16 + " size = " + aioBubbleRecom$GetAioRecommendRsp.items.size());
                if (z16 && aioBubbleRecom$GetAioRecommendRsp.items.size() > 0) {
                    fontBubblePanelView.C.x(aioBubbleRecom$GetAioRecommendRsp.ruleId.get());
                    fontBubblePanelView.r(aioBubbleRecom$GetAioRecommendRsp);
                } else {
                    QLog.e("AIOFontBubble_FontBubblePanelView", 1, "onGetFontRecommend failed, size:" + aioBubbleRecom$GetAioRecommendRsp.items.size());
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73501);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            K = new boolean[5];
        }
    }

    public FontBubblePanelView(Context context, com.tencent.aio.api.runtime.a aVar, AppRuntime appRuntime, EditText editText, com.tencent.mobileqq.panel.f fVar, c<T> cVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, aVar, appRuntime, editText, fVar, cVar);
            return;
        }
        this.f257128i = new ArrayList();
        this.J = new f(this);
        setAppRuntime(appRuntime);
        setEditText(editText);
        this.D = aVar;
        this.f257129m = cVar;
        this.f257126f = cVar.getType();
        this.C = FontBubbleManager.j((QQAppInterface) appRuntime);
        this.G = context.getResources().getDrawable(R.drawable.f162110ao3);
        this.H = fVar;
        this.I = new FontBubbleEventReceiver();
        p();
    }

    public static void k() {
        int i3 = 0;
        while (true) {
            boolean[] zArr = K;
            if (i3 < zArr.length) {
                zArr[i3] = false;
                i3++;
            } else {
                return;
            }
        }
    }

    private int l(int i3) {
        if (i3 != 300) {
            if (i3 != 600) {
                return R.drawable.f162134nv3;
            }
            return R.drawable.f162135nv4;
        }
        return R.drawable.nv5;
    }

    @Nullable
    private Drawable m(String str) {
        if (q(str)) {
            return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(str);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = this.G;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mPlayGifImage = true;
        return URLDrawable.getDrawable(str, obtain);
    }

    private Drawable n(String str) {
        if (TextUtils.isEmpty(str)) {
            return new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{Color.parseColor("#80a8a8a8"), Color.parseColor("#4da8a8a8")});
        }
        return new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{Color.parseColor("#80" + str), Color.parseColor("#4d" + str)});
    }

    public static String o(int i3) {
        if (i3 == 3) {
            return "1";
        }
        return "2";
    }

    private void p() {
        k();
        FontBubble fontBubble = new FontBubble();
        fontBubble.viewType = 0;
        this.f257128i.add(fontBubble);
        Context context = getContext();
        Resources resources = context.getResources();
        RichTextPanelRecyclerView richTextPanelRecyclerView = new RichTextPanelRecyclerView(context);
        this.E = richTextPanelRecyclerView;
        richTextPanelRecyclerView.setOverScrollMode(2);
        this.E.setLayoutManager(new GridLayoutManager(context, 4));
        FontBubblePanelView<T>.d dVar = new d();
        this.F = dVar;
        this.E.setAdapter(dVar);
        this.E.setPanelExtendHelper(this.H);
        setClipToPadding(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int f16 = BaseAIOUtils.f(8.0f, resources);
        this.E.setPadding(BaseAIOUtils.f(8.0f, resources), f16, BaseAIOUtils.f(3.0f, resources), 0);
        addView(this.E, layoutParams);
    }

    private boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith("png") && !str.endsWith("PNG")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(T t16) {
        new QueryTask(new a(), new b()).a(t16);
    }

    private void t(ImageView imageView, @NotNull FontBubble fontBubble) {
        int i3;
        int i16 = fontBubble.feeType;
        int i17 = fontBubble.price;
        if (i16 != 0 && i16 != 1) {
            if (i16 != 2) {
                if (i16 != 4) {
                    if (i16 != 5) {
                        if (i16 != 21) {
                            if (i16 != 22) {
                                i3 = R.drawable.foh;
                            } else {
                                i3 = R.drawable.fth;
                            }
                        } else {
                            i3 = R.drawable.fti;
                        }
                    } else {
                        i3 = R.drawable.nv6;
                    }
                } else {
                    i3 = R.drawable.nv9;
                }
            } else {
                i3 = l(i17);
            }
        } else {
            i3 = R.drawable.fkt;
        }
        if (fontBubble.isQualified) {
            i3 = R.drawable.nuj;
        }
        imageView.setVisibility(0);
        Resources resources = getResources();
        Drawable drawable = resources.getDrawable(i3);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        imageView.setImageDrawable(drawable);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int f16 = BaseAIOUtils.f(10.0f, resources);
        layoutParams.height = f16;
        layoutParams.width = (f16 * intrinsicWidth) / intrinsicHeight;
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public String a() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f257126f == 3) {
            i3 = R.string.mmu;
        } else {
            i3 = R.string.mmt;
        }
        return HardCodeUtil.qqStr(i3);
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (z16) {
            com.tencent.mobileqq.panel.bubble.d.j(this.f257126f, this.C.k());
            this.I.d();
            ((AppInterface) this.f257150d).addObserver(this.J);
            boolean[] zArr = K;
            int i3 = this.f257126f;
            if (!zArr[i3]) {
                zArr[i3] = true;
                this.f257129m.d((ISVIPHandler) ((AppInterface) this.f257150d).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER));
                return;
            }
            return;
        }
        this.I.e();
        ((AppInterface) this.f257150d).removeObserver(this.J);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j3;
        long j16;
        int i3;
        int i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ci9) {
                FontBubble fontBubble = (FontBubble) view.getTag();
                if (fontBubble.viewType == 1) {
                    if (this.f257151e.getText().length() > 0) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (this.f257127h + 1000 < uptimeMillis) {
                            this.C.w(fontBubble, this.D, getContext());
                        }
                        this.f257127h = uptimeMillis;
                    }
                    int i17 = this.f257126f;
                    if (i17 == 3) {
                        i3 = fontBubble.fontId;
                    } else {
                        i3 = fontBubble.bubbleId;
                    }
                    if (i17 == 3) {
                        i16 = fontBubble.fontId;
                    } else {
                        i16 = fontBubble.bubbleId;
                    }
                    com.tencent.mobileqq.panel.bubble.d.e(i17, i16, this.C.k());
                    VasWebviewUtil.reportCommercialDrainage(this.f257150d.getCurrentUin(), "aio_iconA", "Clickitem", "", 1, 0, 0, "", Integer.toString(i3), o(this.f257126f));
                } else {
                    Context context = getContext();
                    String addEntryParamToUrl = VasWebviewUtil.addEntryParamToUrl(this.f257129m.b(context), 39);
                    if (this.f257126f == 3) {
                        j16 = 4096;
                    } else {
                        j16 = 64;
                    }
                    VasWebviewUtil.openQQBrowserWithoutAD(context, addEntryParamToUrl, j16, null, false, -1);
                    com.tencent.mobileqq.panel.bubble.d.i(this.f257126f, this.C.k());
                    VasWebviewUtil.reportCommercialDrainage(this.f257150d.getCurrentUin(), "aio_iconA", "ClickPlus", "", 1, 0, 0, "", "", o(this.f257126f));
                }
            } else if (id5 == R.id.vd8) {
                Context context2 = getContext();
                String addEntryParamToUrl2 = VasWebviewUtil.addEntryParamToUrl(this.f257129m.b(context2), 39);
                if (this.f257126f == 3) {
                    j3 = 4096;
                } else {
                    j3 = 64;
                }
                VasWebviewUtil.openQQBrowserWithoutAD(context2, addEntryParamToUrl2, j3, null, false, -1);
                com.tencent.mobileqq.panel.bubble.d.i(this.f257126f, this.C.k());
                VasWebviewUtil.reportCommercialDrainage(this.f257150d.getCurrentUin(), "aio_iconA", "ClickPlus", "", 1, 0, 0, "", "", o(this.f257126f));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            VasWebviewUtil.reportCommercialDrainage(this.f257150d.getCurrentUin(), "aio_iconA", "PanelPageView", "", 1, 0, 0, "", "", o(this.f257126f));
        }
    }

    public void u(FontBubblePanelView<T>.e eVar, FontBubble fontBubble) {
        Drawable drawable;
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar, (Object) fontBubble);
            return;
        }
        eVar.f257133d.getLayoutParams().height = (ViewUtils.getScreenWidth() / 4) - BaseAIOUtils.f(5.0f, getResources());
        eVar.f257134e.getLayoutParams().height = eVar.f257133d.getLayoutParams().height;
        if (fontBubble.viewType == 1) {
            try {
                if (TextUtils.isEmpty(fontBubble.picUrl)) {
                    str = this.f257129m.e(fontBubble);
                } else {
                    str = fontBubble.picUrl;
                }
                drawable = m(str);
                int i16 = this.f257126f;
                if (i16 == 3) {
                    i3 = fontBubble.fontId;
                } else {
                    i3 = fontBubble.bubbleId;
                }
                com.tencent.mobileqq.panel.bubble.d.f(i16, i3, this.C.k());
            } catch (Exception e16) {
                QLog.e("AIOFontBubble_FontBubblePanelView", 1, "updateView: ", e16);
                drawable = null;
            }
            eVar.f257133d.setScaleType(ImageView.ScaleType.FIT_XY);
            eVar.f257133d.setImageDrawable(drawable);
            t(eVar.f257137i, fontBubble);
            eVar.f257136h.setPadding(0, BaseAIOUtils.f(0.7f, getResources()), 0, 0);
            eVar.f257136h.setText(fontBubble.name);
            eVar.f257135f.setVisibility(8);
            eVar.f257133d.setVisibility(0);
        } else {
            eVar.f257135f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            eVar.f257135f.setImageResource(R.drawable.foi);
            eVar.f257135f.setVisibility(0);
            eVar.f257133d.setVisibility(8);
            eVar.f257137i.setVisibility(8);
            eVar.f257136h.setVisibility(8);
        }
        eVar.f257133d.setTag(fontBubble);
        eVar.f257134e.setImageDrawable(n(fontBubble.itemBgColor));
        eVar.f257133d.setOnClickListener(this);
        eVar.f257135f.setOnClickListener(this);
    }
}
