package com.tencent.mobileqq.guild.message.chatpie;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.EmoticonCallbackWithView;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.message.api.IGuildRecentUseEmojiHandler;
import com.tencent.mobileqq.guild.message.chatpie.GuildEmojiReactionView;
import com.tencent.mobileqq.guild.message.v;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.t;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements View.OnClickListener {
    private boolean C;
    private final int D;
    private final Activity E;
    private final com.tencent.mobileqq.guild.emoj.b F;
    private final List<EmotionPanelData> G;
    private final v H = new C7849a();
    private final EmoticonCallbackWithView I = new g();

    /* renamed from: d, reason: collision with root package name */
    private Dialog f230345d;

    /* renamed from: e, reason: collision with root package name */
    private GuildEmojiReactionView f230346e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f230347f;

    /* renamed from: h, reason: collision with root package name */
    private IEmoticonMainPanel f230348h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.guild.emoj.f f230349i;

    /* renamed from: m, reason: collision with root package name */
    private h f230350m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.message.chatpie.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C7849a extends v {
        C7849a() {
        }

        @Override // com.tencent.mobileqq.guild.message.v
        protected void a(boolean z16, Object obj) {
            QLog.d("GuildEmojiPanel", 1, "handleRecentUsedEmojis isSuccess=", Boolean.valueOf(z16));
            if (z16) {
                a.this.f230348h.updateRecentEmoji(a.this.s(oi1.g.e().f()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f230350m != null) {
                a.this.f230350m.onDismiss();
            }
            a.this.f230349i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f230353d;

        c(ViewGroup.LayoutParams layoutParams) {
            this.f230353d = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f230353d.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            a.this.f230347f.setLayoutParams(this.f230353d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements EmoticonListProvider {
        d() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
        public List<EmotionPanelInfo> getEmotionPanelInfo(boolean z16, boolean z17) {
            ArrayList arrayList = new ArrayList();
            int i3 = EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI;
            arrayList.add(new EmotionPanelInfo(16, i3, null));
            arrayList.add(new EmotionPanelInfo(1, i3, null));
            arrayList.add(new EmotionPanelInfo(2, i3, null));
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements GuildEmojiReactionView.a {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.message.chatpie.GuildEmojiReactionView.a
        public void a() {
            a aVar = a.this;
            aVar.n(aVar.D - ViewUtils.dpToPx(36.0f));
        }

        @Override // com.tencent.mobileqq.guild.message.chatpie.GuildEmojiReactionView.a
        public void b(float f16) {
            ViewGroup.LayoutParams layoutParams = a.this.f230347f.getLayoutParams();
            layoutParams.height = (int) (layoutParams.height + f16);
            a.this.f230347f.setLayoutParams(layoutParams);
        }

        @Override // com.tencent.mobileqq.guild.message.chatpie.GuildEmojiReactionView.a
        public void c() {
            if (a.this.f230346e != null) {
                a aVar = a.this;
                aVar.n(aVar.f230346e.getHeight() - ViewUtils.dpToPx(192.0f));
            }
        }

        @Override // com.tencent.mobileqq.guild.message.chatpie.GuildEmojiReactionView.a
        public void d() {
            a.this.p();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class g implements EmoticonCallbackWithView {
        g() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallbackWithView
        public void send(EmoticonInfo emoticonInfo, View view) {
            if (!a.this.C) {
                if (!NetworkUtil.isNetworkAvailable(a.this.E)) {
                    QQToast.makeText(a.this.E, a.this.E.getString(R.string.f1510816q), 0).show();
                    return;
                }
                ((Vibrator) a.this.E.getSystemService("vibrator")).vibrate(20L);
                if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                    int serverId = QQSysAndEmojiResMgr.getInstance().getResImpl(systemAndEmojiEmoticonInfo.emotionType).getServerId(systemAndEmojiEmoticonInfo.code);
                    QLog.d("GuildEmojiPanel", 1, "send info.type=" + systemAndEmojiEmoticonInfo.type + ", info.code=" + systemAndEmojiEmoticonInfo.code + ", serverId=" + serverId);
                    if (a.this.f230349i != null) {
                        a.this.f230349i.a(a.this.F.f217873g, a.this.F.f217872f, a.this.F.f217870d, serverId, systemAndEmojiEmoticonInfo.emotionType, true);
                    }
                    oi1.g.e().i(systemAndEmojiEmoticonInfo);
                    a.this.q();
                    if (a.this.f230348h.getLastPosition() == 0) {
                        qi1.a.c(view, systemAndEmojiEmoticonInfo);
                    }
                    qi1.a.d(view, a.this.f230346e, systemAndEmojiEmoticonInfo, a.this.F, a.this.f230348h.getLastPosition());
                    return;
                }
                return;
            }
            QLog.d("GuildEmojiPanel", 1, "send mIsInExitAnim=true");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface h {
        void onDismiss();
    }

    public a(com.tencent.mobileqq.guild.emoj.b bVar, int i3, List<EmotionPanelData> list, com.tencent.mobileqq.guild.emoj.f fVar) {
        this.F = bVar;
        this.E = bVar.f217875i;
        this.D = i3;
        this.G = list;
        this.f230349i = fVar;
    }

    public static a A(com.tencent.mobileqq.guild.emoj.b bVar, int i3, com.tencent.mobileqq.guild.emoj.f fVar, h hVar) {
        w(bVar);
        a aVar = new a(bVar, i3, oi1.g.e().f(), fVar);
        aVar.x(hVar);
        aVar.B();
        return aVar;
    }

    private void B() {
        this.f230345d = o();
        v();
        z();
    }

    public static void C(com.tencent.mobileqq.guild.emoj.b bVar, int i3, com.tencent.mobileqq.guild.emoj.f fVar) {
        w(bVar);
        new a(bVar, i3, oi1.g.e().f(), fVar).B();
    }

    public static void D(com.tencent.mobileqq.guild.emoj.b bVar, int i3, List<EmotionPanelData> list, com.tencent.mobileqq.guild.emoj.f fVar) {
        new a(bVar, i3, list, fVar).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3) {
        ViewGroup.LayoutParams layoutParams = this.f230347f.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(layoutParams.height, i3);
        ofInt.setDuration(250L);
        ofInt.addUpdateListener(new c(layoutParams));
        ofInt.start();
    }

    private Dialog o() {
        Dialog c16 = t.c(this.E, R.style.awe);
        Window window = c16.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.awf);
            window.setDimAmount(0.4f);
        }
        this.F.f217874h.addObserver(this.H);
        c16.setOnDismissListener(new b());
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.C = true;
        this.f230346e.setOnClickListener(null);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.E, R.anim.f154458a7);
        loadAnimation.setAnimationListener(new f());
        this.f230346e.startAnimation(loadAnimation);
    }

    private List<EmotionPanelData> r() {
        ArrayList arrayList = new ArrayList();
        List<Integer> filterEmojiData = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getFilterEmojiData();
        if (filterEmojiData == null) {
            return arrayList;
        }
        Iterator<Integer> it = filterEmojiData.iterator();
        while (it.hasNext()) {
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, it.next().intValue(), "", false));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<EmotionPanelData> s(List<EmotionPanelData> list) {
        return new ArrayList(list.subList(0, Math.min(EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI * 3, list.size())));
    }

    private List<EmotionPanelData> t() {
        List<EmotionPanelData> u16 = u();
        u16.addAll(r());
        return u16;
    }

    private List<EmotionPanelData> u() {
        ArrayList arrayList = new ArrayList();
        List<Integer> filterSysData = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getFilterSysData();
        if (filterSysData == null) {
            return arrayList;
        }
        Iterator<Integer> it = filterSysData.iterator();
        while (it.hasNext()) {
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, it.next().intValue(), "", false));
        }
        return arrayList;
    }

    private void v() {
        this.f230346e = (GuildEmojiReactionView) LayoutInflater.from(this.E).inflate(R.layout.ema, (ViewGroup) null);
        IEmoticonMainPanelService.PanelBuilder emoticonListProvider = ((IEmoticonMainPanelService) this.F.f217874h.getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(this.E, 10014).setCallBack(this.I).setDisableMoreEmotionButton(true).setStyleChange(true).keepLottieMerged(true).setCustomEmotionData(16, s(this.G)).setFilterEmotionData(16, t()).setFilterEmotionData(1, u()).setFilterEmotionData(2, r()).setEmoticonListProvider(new d());
        IEmoticonMainPanelService.PanelBuilder.PanelContainerStyleSheet panelContainerStyleSheet = new IEmoticonMainPanelService.PanelBuilder.PanelContainerStyleSheet();
        com.tencent.mobileqq.guild.emoj.b bVar = this.F;
        panelContainerStyleSheet.contentBg = bVar.f217876j;
        panelContainerStyleSheet.tabContainerBg = bVar.f217877k;
        emoticonListProvider.setStyleSheet(panelContainerStyleSheet);
        int i3 = EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI;
        emoticonListProvider.addEmotionInjectionInfo("recent_emoticon", new EmotionInjectionInfo(16, i3, R.drawable.guild_recent_emoticon, null, R.color.qui_common_icon_secondary));
        emoticonListProvider.addEmotionInjectionInfo("sys_emoticon", new EmotionInjectionInfo(1, i3, R.drawable.guild_sys_emoticon, null, R.color.qui_common_icon_secondary));
        emoticonListProvider.addEmotionInjectionInfo("emoji_emoticon", new EmotionInjectionInfo(2, i3, R.drawable.guild_emoji_emoticon, null));
        IEmoticonMainPanel create = emoticonListProvider.create();
        this.f230348h = create;
        create.setEmoSettingVisibility(8);
        this.f230348h.setTabSecondaryEmoticonPadding(ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(36.0f));
        this.f230347f = this.f230348h.getView();
        int dpToPx = this.D - ViewUtils.dpToPx(36.0f);
        this.f230346e.addView(this.f230347f, new RelativeLayout.LayoutParams(-1, dpToPx));
        this.f230346e.setContentHeight(dpToPx);
        this.f230346e.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.f230346e.findViewById(R.id.f165080ut2);
        relativeLayout.setOnClickListener(this);
        this.f230346e.setTitleBar(relativeLayout);
        this.f230346e.setAtPanelTouchListener(new e());
        this.f230345d.setContentView(this.f230346e);
        y();
    }

    private static void w(com.tencent.mobileqq.guild.emoj.b bVar) {
        QLog.d("GuildEmojiPanel", 1, "showWithAnim");
        ((IGuildRecentUseEmojiHandler) bVar.f217874h.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRecentUseEmojiHandlerName())).reqRecentUseEmojiList();
    }

    private void x(h hVar) {
        this.f230350m = hVar;
    }

    private void y() {
        VideoReport.addToDetectionWhitelist(this.E);
        VideoReport.setPageId(this.f230346e, "pg_aio_menu_emoji_comment_more");
        HashMap hashMap = new HashMap();
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(this.F.f217871e, hashMap);
        hashMap.put("pgid", "pg_aio_menu_emoji_comment_more");
        VideoReport.reportEvent("dt_imp", this.f230346e, hashMap);
    }

    private void z() {
        QLog.d("GuildEmojiPanel", 1, "show");
        if (!this.E.isFinishing()) {
            this.f230345d.show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.f230346e.f() && view.getId() != R.id.f165080ut2) {
            q();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p() {
        QLog.d("GuildEmojiPanel", 1, "dismiss");
        this.F.f217874h.removeObserver(this.H);
        this.f230345d.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements Animation.AnimationListener {
        f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.p();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
