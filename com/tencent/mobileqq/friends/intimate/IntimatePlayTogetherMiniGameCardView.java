package com.tencent.mobileqq.friends.intimate;

import NS_MINI_APP_MISC.MISC$StAppPlayingInfo;
import NS_MINI_APP_MISC.MISC$StGetFriendPlayListV2Rsp;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonBody;
import tencent.im.oidb.oidb_0xd84$RspBody;

/* loaded from: classes12.dex */
public class IntimatePlayTogetherMiniGameCardView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f211746d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f211747e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f211748f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f211749h;

    /* renamed from: i, reason: collision with root package name */
    private View f211750i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MISC$StGetFriendPlayListV2Rsp f211754d;

        a(MISC$StGetFriendPlayListV2Rsp mISC$StGetFriendPlayListV2Rsp) {
            this.f211754d = mISC$StGetFriendPlayListV2Rsp;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IntimatePlayTogetherMiniGameCardView.this, (Object) mISC$StGetFriendPlayListV2Rsp);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (this.f211754d.total.get() <= 1) {
                QLog.d("IntimatePlayTogetherMin", 1, NodeProps.ON_CLICK, "will not jump because total count less than 2");
            } else if (TextUtils.isEmpty(this.f211754d.moreJumpLink.get())) {
                QLog.e("IntimatePlayTogetherMin", 1, NodeProps.ON_CLICK, "Could not launch with empty jump url");
            } else {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(IntimatePlayTogetherMiniGameCardView.this.getContext(), this.f211754d.moreJumpLink.get(), 2064, null);
                IntimatePlayTogetherMiniGameCardView.e();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes12.dex */
    public static class b extends RecyclerView.Adapter<c> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private List<MISC$StAppPlayingInfo> f211756d;

        /* renamed from: e, reason: collision with root package name */
        private final String f211757e;

        /* renamed from: f, reason: collision with root package name */
        private int f211758f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f211759h;

        /* renamed from: i, reason: collision with root package name */
        private ColorStateList f211760i;

        /* renamed from: m, reason: collision with root package name */
        private int f211761m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MISC$StAppPlayingInfo f211762d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f211763e;

            a(MISC$StAppPlayingInfo mISC$StAppPlayingInfo, boolean z16) {
                this.f211762d = mISC$StAppPlayingInfo;
                this.f211763e = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, mISC$StAppPlayingInfo, Boolean.valueOf(z16));
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    MiniGamePlayTogetherHandler.b(view.getContext(), this.f211762d.appMetaInfo, b.this.f211757e, b.this.f211758f, this.f211763e);
                    IntimatePlayTogetherMiniGameCardView.e();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(List<MISC$StAppPlayingInfo> list, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list, (Object) str);
                return;
            }
            this.f211758f = 9999;
            this.f211756d = list;
            this.f211757e = str;
        }

        private void r(c cVar, boolean z16, int i3) {
            int i16;
            int i17;
            if (!z16) {
                if (i3 == 0) {
                    i17 = R.string.ir5;
                } else {
                    i17 = R.string.f175962zz;
                }
                cVar.f().setText(i17);
                cVar.f211765d.setVisibility(0);
                cVar.f211766e.setVisibility(8);
                return;
            }
            cVar.f211765d.setVisibility(8);
            cVar.f211766e.setVisibility(0);
            Button button = cVar.f211766e;
            if (z16) {
                i16 = R.string.ir6;
            } else {
                i16 = R.string.f161261x9;
            }
            button.setText(i16);
        }

        private void x(c cVar) {
            try {
                if (this.f211760i != null) {
                    cVar.b().setTextColor(this.f211760i);
                    cVar.e().setTextColor(this.f211760i);
                } else {
                    cVar.b().setTextColor(this.f211761m);
                    cVar.e().setTextColor(this.f211761m);
                }
            } catch (Throwable th5) {
                QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", th5);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return 1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c cVar, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar, i3);
            } else {
                MISC$StAppPlayingInfo mISC$StAppPlayingInfo = this.f211756d.get(i3);
                if (mISC$StAppPlayingInfo != null) {
                    boolean a16 = MiniGamePlayTogetherHandler.a(mISC$StAppPlayingInfo.appMetaInfo);
                    cVar.itemView.setOnClickListener(new a(mISC$StAppPlayingInfo, a16));
                    cVar.g().setVisibility(0);
                    cVar.c().setVisibility(0);
                    cVar.e().setVisibility(0);
                    if (mISC$StAppPlayingInfo.appMetaInfo != null) {
                        cVar.b().setText(mISC$StAppPlayingInfo.appMetaInfo.appName.get());
                        cVar.d().setImageDrawable(((IMiniAppService) QRoute.api(IMiniAppService.class)).getIcon(cVar.d().getContext(), mISC$StAppPlayingInfo.appMetaInfo.icon.get(), true));
                    }
                    IntimatePlayTogetherMiniGameCardView.f(cVar.c(), this.f211757e);
                    if (mISC$StAppPlayingInfo.myRank.get() != 0 && mISC$StAppPlayingInfo.friendRank.get() != 0) {
                        if (mISC$StAppPlayingInfo.myRank.get() == mISC$StAppPlayingInfo.friendRank.get()) {
                            cVar.e().setText(R.string.f171040ir1);
                        } else {
                            TextView e16 = cVar.e();
                            if (mISC$StAppPlayingInfo.myRank.get() < mISC$StAppPlayingInfo.friendRank.get()) {
                                i16 = R.string.f171042ir3;
                            } else {
                                i16 = R.string.f171041ir2;
                            }
                            e16.setText(i16);
                        }
                    } else if (mISC$StAppPlayingInfo.myRank.get() == 0 && mISC$StAppPlayingInfo.friendRank.get() > 0) {
                        cVar.e().setText(String.format(cVar.itemView.getContext().getString(R.string.f171043ir4), Integer.valueOf(mISC$StAppPlayingInfo.friendRank.get())));
                    } else {
                        cVar.g().setVisibility(8);
                        cVar.c().setVisibility(8);
                        cVar.e().setVisibility(8);
                    }
                    r(cVar, a16, mISC$StAppPlayingInfo.playType.get());
                    if (this.f211759h) {
                        x(cVar);
                    }
                }
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(cVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (c) iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup, i3);
            }
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c8n, (ViewGroup) null, false));
        }

        public void u(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.f211758f = i3;
            }
        }

        public void v(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f211759h = true;
                this.f211761m = i3;
            }
        }

        public void w(ColorStateList colorStateList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) colorStateList);
            } else {
                this.f211759h = true;
                this.f211760i = colorStateList;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        private TextView C;
        private View D;

        /* renamed from: d, reason: collision with root package name */
        public ViewGroup f211765d;

        /* renamed from: e, reason: collision with root package name */
        public Button f211766e;

        /* renamed from: f, reason: collision with root package name */
        private URLImageView f211767f;

        /* renamed from: h, reason: collision with root package name */
        private TextView f211768h;

        /* renamed from: i, reason: collision with root package name */
        private TextView f211769i;

        /* renamed from: m, reason: collision with root package name */
        private ThemeImageView f211770m;

        c(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.f211767f = (URLImageView) view.findViewById(R.id.lm_);
            this.f211768h = (TextView) view.findViewById(R.id.lmb);
            this.f211769i = (TextView) view.findViewById(R.id.lme);
            this.f211770m = (ThemeImageView) view.findViewById(R.id.lm8);
            this.C = (TextView) view.findViewById(R.id.lmd);
            this.f211766e = (Button) view.findViewById(R.id.lmc);
            this.D = view.findViewById(R.id.lm9);
            this.f211765d = (ViewGroup) view.findViewById(R.id.xqx);
        }

        TextView b() {
            return this.f211768h;
        }

        public ThemeImageView c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ThemeImageView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f211770m;
        }

        URLImageView d() {
            return this.f211767f;
        }

        TextView e() {
            return this.C;
        }

        public TextView f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f211769i;
        }

        View g() {
            return this.D;
        }
    }

    public IntimatePlayTogetherMiniGameCardView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            d(context, null, 0);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void c(int i3, String str, boolean z16) {
        this.f211749h.setVisibility(4);
        this.f211750i.setVisibility(0);
        this.f211748f.setText(str);
        if (i3 == 0) {
            this.f211747e.setText(R.string.f161141wx);
        } else {
            this.f211747e.setText(R.string.f161131ww);
        }
    }

    private void d(Context context, AttributeSet attributeSet, int i3) {
        LayoutInflater.from(context).inflate(R.layout.c8m, this);
        this.f211746d = (RecyclerView) findViewById(R.id.liy);
        this.f211747e = (TextView) findViewById(R.id.f165296lj1);
        this.f211748f = (TextView) findViewById(R.id.vfl);
        this.f211749h = (ImageView) findViewById(R.id.liz);
        this.f211750i = findViewById(R.id.vfk);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        QLog.d("IntimatePlayTogetherMin", 1, " reportGameTogetherClick");
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_mini_game_entry", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(ThemeImageView themeImageView, String str) {
        if (themeImageView != null && !TextUtils.isEmpty(str)) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
                Bitmap bitmapFromCache = iQQAvatarService.getBitmapFromCache(1, str, 0, (byte) 4);
                if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
                    iQQAvatarService.destory();
                    themeImageView.setImageBitmap(bitmapFromCache);
                } else {
                    iQQAvatarService.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener(themeImageView) { // from class: com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ ThemeImageView f211752e;

                        {
                            this.f211752e = themeImageView;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IFaceDecoder.this, (Object) themeImageView);
                            }
                        }

                        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
                        public void onDecodeTaskCompleted(int i3, int i16, String str2, Bitmap bitmap) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str2, bitmap);
                                return;
                            }
                            IFaceDecoder.this.destory();
                            if (!TextUtils.isEmpty(str2) && bitmap != null && !bitmap.isRecycled()) {
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.2.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Bitmap f211753d;

                                    {
                                        this.f211753d = bitmap;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) bitmap);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            AnonymousClass2.this.f211752e.setImageBitmap(this.f211753d);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    iQQAvatarService.requestDecodeFace(str, 200, false, 1, true, (byte) 0, 4);
                }
            }
        }
    }

    public static void h(View view, IntimateInfo intimateInfo) {
        IntimatePlayTogetherMiniGameCardView intimatePlayTogetherMiniGameCardView;
        if ((view instanceof ViewGroup) && (intimatePlayTogetherMiniGameCardView = (IntimatePlayTogetherMiniGameCardView) ((ViewGroup) view).findViewById(R.id.lix)) != null) {
            intimatePlayTogetherMiniGameCardView.g(intimateInfo);
        }
    }

    public void g(IntimateInfo intimateInfo) {
        List<oidb_0xcf4$CommonBody> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intimateInfo);
            return;
        }
        if (intimateInfo != null && (list = intimateInfo.commonBodies) != null && !list.isEmpty()) {
            oidb_0xcf4$CommonBody oidb_0xcf4_commonbody = null;
            for (oidb_0xcf4$CommonBody oidb_0xcf4_commonbody2 : intimateInfo.commonBodies) {
                if (oidb_0xcf4_commonbody2.uint32_oidb_cmd.get() == 3460) {
                    oidb_0xcf4_commonbody = oidb_0xcf4_commonbody2;
                }
            }
            boolean z16 = true;
            if (oidb_0xcf4_commonbody == null) {
                QLog.e("IntimatePlayTogetherMin", 1, "updateIntimateInfo", "no 0xd84 cmd found in common body response");
                setVisibility(8);
                return;
            }
            try {
                oidb_0xd84$RspBody oidb_0xd84_rspbody = new oidb_0xd84$RspBody();
                oidb_0xd84_rspbody.mergeFrom(oidb_0xcf4_commonbody.string_oidb_body.get().toByteArray());
                MISC$StGetFriendPlayListV2Rsp mISC$StGetFriendPlayListV2Rsp = new MISC$StGetFriendPlayListV2Rsp();
                mISC$StGetFriendPlayListV2Rsp.mergeFrom(oidb_0xd84_rspbody.bytes_xmitinfo.get().toByteArray());
                if (mISC$StGetFriendPlayListV2Rsp.appPlayingInfos.size() <= 0) {
                    QLog.e("IntimatePlayTogetherMin", 1, "updateIntimateInfo: stGetFriendPlayListV2Rsp infos is null.");
                    setVisibility(8);
                    return;
                }
                a aVar = new a(mISC$StGetFriendPlayListV2Rsp);
                setVisibility(0);
                int i3 = mISC$StGetFriendPlayListV2Rsp.appPlayingInfos.get(0).playType.get();
                if (mISC$StGetFriendPlayListV2Rsp.total.get() < 2 || TextUtils.isEmpty(mISC$StGetFriendPlayListV2Rsp.moreJumpLink.get())) {
                    z16 = false;
                }
                c(i3, String.valueOf(mISC$StGetFriendPlayListV2Rsp.total.get()), z16);
                RecyclerView recyclerView = this.f211746d;
                if (recyclerView != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    b bVar = new b(mISC$StGetFriendPlayListV2Rsp.appPlayingInfos.get(), intimateInfo.friendUin);
                    bVar.u(2064);
                    this.f211746d.setAdapter(bVar);
                }
                INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = mISC$StGetFriendPlayListV2Rsp.appPlayingInfos.get().get(0).appMetaInfo;
                SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(iNTERFACE$StApiAppInfo));
                SimpleMiniAppConfig.SimpleLaunchParam simpleLaunchParam = simpleMiniAppConfig.launchParam;
                if (simpleLaunchParam != null) {
                    simpleLaunchParam.scene = 2064;
                }
                if (MiniGamePlayTogetherHandler.a(iNTERFACE$StApiAppInfo)) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(simpleMiniAppConfig, "c2close", "expo", null, null);
                } else {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameProfile(simpleMiniAppConfig, 2064, false);
                }
                if (z16) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).onMiniGameCardShowMoreView(mISC$StGetFriendPlayListV2Rsp.moreJumpLink.get(), 2, mISC$StGetFriendPlayListV2Rsp.total.get());
                }
                setOnClickListener(aVar);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("IntimatePlayTogetherMin", 2, "updateIntimateInfo: parse rep exception.", e16);
                setVisibility(8);
                return;
            }
        }
        setVisibility(8);
    }

    public IntimatePlayTogetherMiniGameCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            d(context, attributeSet, 0);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public IntimatePlayTogetherMiniGameCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            d(context, attributeSet, i3);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
