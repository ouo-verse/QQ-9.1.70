package com.tencent.mobileqq.zplan.avatar.impl.fragment.helper;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import b94.a;
import b94.d;
import b94.e;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewInitData;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.sqshow.zootopia.nativeui.ue.n;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import uv4.az;
import uv4.u;
import zi3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u00013B=\u0012\u0006\u0010>\u001a\u00020<\u0012\b\u0010A\u001a\u0004\u0018\u00010?\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010F\u001a\u00020C\u0012\b\b\u0002\u0010H\u001a\u00020\u0007\u0012\b\b\u0002\u0010J\u001a\u00020\u0007\u00a2\u0006\u0004\bY\u0010ZJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001J\u0006\u0010\u000e\u001a\u00020\nJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J&\u0010%\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020&H\u0016J,\u00100\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0018\u00103\u001a\u00020\n2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u0007H\u0016J&\u00107\u001a\u00020\n2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010$\u001a\u00020#2\u0006\u00106\u001a\u000205H\u0016J\b\u00108\u001a\u00020\u0007H\u0016J\b\u00109\u001a\u00020\nH\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\u0006\u0010;\u001a\u00020\nR\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010=R\u0016\u0010A\u001a\u0004\u0018\u00010?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010@R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010@R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010GR\u0014\u0010J\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010GR\u0014\u0010O\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010GR\u0016\u0010S\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010GR$\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u00010Tj\b\u0012\u0004\u0012\u00020\u0001`U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/b;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/a;", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "sceneInfo", "Lb94/a;", "engineApi", "", "forceUsePanel", "withoutUI", "", "l", "k", "i", "destroy", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "getCameraId", "Lb94/e;", "j", DomainData.DOMAIN_NAME, "La84/a;", "avatarComponent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "success", "engineInitFinish", "", "Luv4/az;", VideoTemplateParser.ITEM_LIST, "Lqu4/a;", ac.f283467k0, "Lm94/h;", "cb", "g", "", "bgPicPath", "f", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "targetGender", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/u;", "requestCb", "Ljava/lang/Runnable;", "taskAfterRequest", "s0", "cameraId", "withoutBlend", "a", "storeItemList", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/NormalDressStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "b", "d", "e", "c", "p", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "mContext", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mPanelContainer", "mAvatarContainer", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "mSourceCurrent", "Z", "mOnlyMakeUpMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mOnlyBrandMallMode", BdhLogUtil.LogTag.Tag_Conn, "mIsAvatarSubScene", "D", "Lb94/e;", "mControlView", "E", "mNeedPanelView", UserInfo.SEX_FEMALE, "mFirstFrameReady", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "G", "Ljava/util/HashSet;", "mListenerPool", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ZZ)V", "H", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements com.tencent.sqshow.zootopia.avatar.c, com.tencent.mobileqq.zplan.avatar.api.hippy.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsAvatarSubScene;

    /* renamed from: D, reason: from kotlin metadata */
    private final b94.e mControlView;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mNeedPanelView;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mFirstFrameReady;

    /* renamed from: G, reason: from kotlin metadata */
    private final HashSet<com.tencent.sqshow.zootopia.avatar.c> mListenerPool;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FragmentActivity mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mPanelContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mAvatarContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource mSourceCurrent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean mOnlyMakeUpMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean mOnlyBrandMallMode;

    public b(FragmentActivity mContext, ViewGroup viewGroup, ViewGroup mAvatarContainer, ZootopiaSource mSourceCurrent, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mAvatarContainer, "mAvatarContainer");
        Intrinsics.checkNotNullParameter(mSourceCurrent, "mSourceCurrent");
        this.mContext = mContext;
        this.mPanelContainer = viewGroup;
        this.mAvatarContainer = mAvatarContainer;
        this.mSourceCurrent = mSourceCurrent;
        this.mOnlyMakeUpMode = z16;
        this.mOnlyBrandMallMode = z17;
        vb3.a aVar = vb3.a.f441346a;
        b94.e a16 = a.C11684a.a((zi3.a) aVar.b(zi3.a.class), mContext, null, 0, z17, 6, null);
        this.mControlView = a16;
        this.mListenerPool = new HashSet<>();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (viewGroup != null) {
            viewGroup.addView(a16.getView(), new ViewGroup.LayoutParams(-1, -1));
        }
        ((te3.a) aVar.b(te3.a.class)).d(this);
        i(new ej3.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        com.tencent.sqshow.zootopia.avatar.loading.recorder.e.f370046a.b(2).d("AvatarPanelHelper");
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.a
    public void a(CameraKey cameraId, boolean withoutBlend) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        this.mControlView.setCameraId(cameraId, "AvatarPanelHelper", withoutBlend);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.a
    public void b(List<az> storeItemList, m94.h cb5, NormalDressStrategy strategy) {
        Intrinsics.checkNotNullParameter(storeItemList, "storeItemList");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        d.a.d(this.mControlView.getMDressController(), storeItemList, cb5, strategy, null, 8, null);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.a
    public boolean c() {
        Boolean value = n.f371383a.f().getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.a
    /* renamed from: d, reason: from getter */
    public boolean getMFirstFrameReady() {
        return this.mFirstFrameReady;
    }

    public final void destroy() {
        this.mListenerPool.clear();
        this.mControlView.destroy();
        ((te3.a) vb3.a.f441346a.b(te3.a.class)).F(this);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(boolean success) {
        this.mControlView.engineInitFinish(success);
        Iterator<T> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.avatar.c) it.next()).engineInitFinish(success);
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.a
    public void f(String bgPicPath) {
        Intrinsics.checkNotNullParameter(bgPicPath, "bgPicPath");
        this.mControlView.setBackgroundPath(bgPicPath);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.a
    public void g(List<az> itemList, qu4.a ac5, m94.h cb5) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(ac5, "ac");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.mControlView.getMDressController().Bg(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n(), itemList, ac5, cb5);
    }

    public final CameraKey getCameraId() {
        if (this.mIsAvatarSubScene) {
            return this.mControlView.getCameraId();
        }
        return null;
    }

    public final void i(com.tencent.sqshow.zootopia.avatar.c l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.add(l3);
    }

    /* renamed from: j, reason: from getter */
    public final b94.e getMControlView() {
        return this.mControlView;
    }

    public final boolean k() {
        if (this.mNeedPanelView) {
            return e.a.c(this.mControlView, false, null, 3, null);
        }
        return false;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getMNeedPanelView() {
        return this.mNeedPanelView;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.mControlView.onFirstFrame(result);
        Iterator<T> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.avatar.c) it.next()).onFirstFrame(result);
        }
        this.mFirstFrameReady = true;
        if (this.mNeedPanelView) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.o();
                }
            }, 2000L);
        }
    }

    public final void p() {
        d.a.i(this.mControlView.getMDressController(), null, false, 3, null);
    }

    public final void q(a84.a avatarComponent) {
        Intrinsics.checkNotNullParameter(avatarComponent, "avatarComponent");
        if (getMNeedPanelView()) {
            avatarComponent.e9(this.mControlView);
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.a
    public void s0(UEAvatarGender targetGender, com.tencent.mobileqq.zootopia.api.e<u> requestCb, Runnable taskAfterRequest) {
        this.mControlView.getMDressController().s0(targetGender, requestCb, taskAfterRequest);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(boolean connect) {
        this.mControlView.serviceConnected(connect);
        Iterator<T> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.avatar.c) it.next()).serviceConnected(connect);
        }
        if (connect) {
            return;
        }
        this.mFirstFrameReady = false;
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.a
    public void e() {
        QLog.i("AvatarPanelHelper_", 1, "hippyBack");
        p();
    }

    public final void l(SceneInfo sceneInfo, b94.a engineApi, boolean forceUsePanel, boolean withoutUI) {
        String str;
        AvatarNativeViewInitData avatarNativeViewInitData;
        boolean z16;
        Intrinsics.checkNotNullParameter(sceneInfo, "sceneInfo");
        Intrinsics.checkNotNullParameter(engineApi, "engineApi");
        if (!forceUsePanel && !sceneInfo.k()) {
            this.mNeedPanelView = false;
            ViewGroup viewGroup = this.mPanelContainer;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.mAvatarContainer.setAlpha(0.0f);
            return;
        }
        a.C0113a.d(engineApi, null, 1, null);
        this.mNeedPanelView = true;
        URLImageView uRLImageView = new URLImageView(this.mContext);
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (QQTheme.isNowThemeIsNight()) {
            str = "https://static-res.qq.com/static-res/zplan/background/zplan_bg_dark.png";
        } else {
            str = "https://static-res.qq.com/static-res/zplan/background/zplan_bg_light.png";
        }
        CommonExKt.v(uRLImageView, str, R.drawable.qui_common_bg_bottom_standard_bg, null, 4, null);
        this.mAvatarContainer.addView(uRLImageView, new ViewGroup.LayoutParams(-1, -1));
        this.mAvatarContainer.setBackgroundResource(R.drawable.h3u);
        ViewGroup viewGroup2 = this.mPanelContainer;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        this.mIsAvatarSubScene = true;
        FragmentActivity fragmentActivity = this.mContext;
        AvatarNativeViewInitData avatarNativeViewInitData2 = new AvatarNativeViewInitData(fragmentActivity, fragmentActivity, null, null, 0, null, null, null, false, 0 == true ? 1 : 0, null, false, engineApi, null, 0 == true ? 1 : 0, null, null, null, null, 520188, null);
        int c16 = sceneInfo.c();
        if (c16 > 0) {
            avatarNativeViewInitData = avatarNativeViewInitData2;
            avatarNativeViewInitData.u(String.valueOf(c16));
        } else {
            avatarNativeViewInitData = avatarNativeViewInitData2;
        }
        avatarNativeViewInitData.y(sceneInfo.f());
        avatarNativeViewInitData.s(sceneInfo.b());
        avatarNativeViewInitData.C(this.mSourceCurrent);
        avatarNativeViewInitData.B(withoutUI);
        avatarNativeViewInitData.v(engineApi);
        if (this.mOnlyMakeUpMode) {
            z16 = true;
            avatarNativeViewInitData.z(true);
            avatarNativeViewInitData.w(AvatarNativeViewMode.ONLY_MAKE_FACE);
        } else {
            z16 = true;
        }
        this.mControlView.Cf(avatarNativeViewInitData);
        if (withoutUI) {
            return;
        }
        e.a.a(this.mControlView, true, null, null, 6, null);
        this.mControlView.he(z16, 0);
    }

    public static /* synthetic */ void m(b bVar, SceneInfo sceneInfo, b94.a aVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        bVar.l(sceneInfo, aVar, z16, z17);
    }

    public /* synthetic */ b(FragmentActivity fragmentActivity, ViewGroup viewGroup, ViewGroup viewGroup2, ZootopiaSource zootopiaSource, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, viewGroup, viewGroup2, zootopiaSource, (i3 & 16) != 0 ? false : z16, (i3 & 32) != 0 ? false : z17);
    }
}
