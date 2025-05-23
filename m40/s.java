package m40;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.biz.qqcircle.widgets.y;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lm40/s;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "", "w1", "v1", "B1", "Lfeedcloud/FeedCloudMeta$StUser;", QCircleAlphaUserReporter.KEY_USER, "o1", "", "authType", "u1", "(Ljava/lang/Integer;)V", "x1", "A1", "p1", "", "", "", "q1", "r1", "tagName", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "position", "t1", "v", NodeProps.ON_CLICK, "w0", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "I", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", "J", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", "descTv", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "K", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "followView", "Lcom/tencent/biz/qqcircle/widgets/QFSVipNickNameAndIconView;", "L", "Lcom/tencent/biz/qqcircle/widgets/QFSVipNickNameAndIconView;", "posterNick", "Landroid/widget/ImageView;", "M", "Landroid/widget/ImageView;", "authIcon", "N", "Ljava/lang/String;", "contentType", "<init>", "()V", "P", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class s extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    private QCircleAvatarView avatarView;

    /* renamed from: J, reason: from kotlin metadata */
    private QFSExpandableAsyncTextView descTv;

    /* renamed from: K, reason: from kotlin metadata */
    private QFSFollowView followView;

    /* renamed from: L, reason: from kotlin metadata */
    private QFSVipNickNameAndIconView posterNick;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView authIcon;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String contentType = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J'\u0010\u0006\u001a\u00020\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"m40/s$b", "Lcom/tencent/biz/qqcircle/utils/QFSAsyncUtils$Callback;", "Ljava/lang/Void;", "", "", "param", "a", "([Ljava/lang/Void;)Ljava/lang/Integer;", "result", "", "b", "(Ljava/lang/Integer;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QFSAsyncUtils.Callback<Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f416135a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ s f416136b;

        b(FeedCloudMeta$StUser feedCloudMeta$StUser, s sVar) {
            this.f416135a = feedCloudMeta$StUser;
            this.f416136b = sVar;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doBackgroundAction(@NotNull Void... param) {
            Intrinsics.checkNotNullParameter(param, "param");
            return Integer.valueOf(QCirclePluginUtil.getAuthType(this.f416135a));
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(@Nullable Integer result) {
            this.f416136b.u1(result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"m40/s$c", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView$b;", "", "isExpanded", "", "b", NodeProps.ON_CLICK, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements QFSExpandableAsyncTextView.b {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public /* synthetic */ void a(int i3) {
            y.a(this, i3);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public void b(boolean isExpanded) {
            ((QFSBaseFeedChildPresenter) s.this).E.o("KEY_LINEAR_FEED_DESC_IS_EXPANDED", Boolean.valueOf(isExpanded));
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public boolean onClick(boolean isExpanded) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A1() {
        QFSFollowView qFSFollowView = null;
        if (com.tencent.biz.qqcircle.immersive.utils.r.i0((FeedCloudMeta$StFeed) this.f85017h)) {
            QFSFollowView qFSFollowView2 = this.followView;
            if (qFSFollowView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followView");
            } else {
                qFSFollowView = qFSFollowView2;
            }
            qFSFollowView.setVisibility(8);
            return;
        }
        QFSFollowView qFSFollowView3 = this.followView;
        if (qFSFollowView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followView");
            qFSFollowView3 = null;
        }
        qFSFollowView3.setUserData(((FeedCloudMeta$StFeed) this.f85017h).poster.get());
        QFSFollowView qFSFollowView4 = this.followView;
        if (qFSFollowView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followView");
            qFSFollowView4 = null;
        }
        qFSFollowView4.setFollowedDismiss(true);
        QFSFollowView qFSFollowView5 = this.followView;
        if (qFSFollowView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followView");
        } else {
            qFSFollowView = qFSFollowView5;
        }
        qFSFollowView.setItemReportListener(new d());
    }

    private final void B1() {
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView = this.posterNick;
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView2 = null;
        if (qFSVipNickNameAndIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterNick");
            qFSVipNickNameAndIconView = null;
        }
        qFSVipNickNameAndIconView.setUser(n0().poster.get());
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView3 = this.posterNick;
        if (qFSVipNickNameAndIconView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterNick");
            qFSVipNickNameAndIconView3 = null;
        }
        qFSVipNickNameAndIconView3.setReportBean(new QFSVipNickNameAndIconView.b().g(n0()).h(1100));
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView4 = this.posterNick;
        if (qFSVipNickNameAndIconView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterNick");
            qFSVipNickNameAndIconView4 = null;
        }
        qFSVipNickNameAndIconView4.w0(n0().poster.nick.get());
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView5 = this.posterNick;
        if (qFSVipNickNameAndIconView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterNick");
        } else {
            qFSVipNickNameAndIconView2 = qFSVipNickNameAndIconView5;
        }
        qFSVipNickNameAndIconView2.setNickNameClickListener(new QFSVipNickNameAndIconView.a() { // from class: m40.r
        });
        FeedCloudMeta$StUser feedCloudMeta$StUser = n0().poster.get();
        Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StUser, "data.poster.get()");
        o1(feedCloudMeta$StUser);
    }

    private final void o1(FeedCloudMeta$StUser user) {
        if (!user.busiData.has()) {
            return;
        }
        QFSAsyncUtils.executeSub(new b(user, this), new Void[0]);
    }

    private final void p1() {
        Map<String, Object> q16 = q1();
        QCircleAvatarView qCircleAvatarView = this.avatarView;
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView = null;
        if (qCircleAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qCircleAvatarView = null;
        }
        g0(qCircleAvatarView, "em_xsj_author_avatar", q16);
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView2 = this.posterNick;
        if (qFSVipNickNameAndIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterNick");
        } else {
            qFSVipNickNameAndIconView = qFSVipNickNameAndIconView2;
        }
        g0(qFSVipNickNameAndIconView, "em_xsj_author_name", q16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> q1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EID, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_FLOW_CARD);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CONTENT_TYPE, this.contentType);
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r1() {
        if (this.f85017h == 0) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(((FeedCloudMeta$StFeed) this.f85017h).poster.get());
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(m0(), qCircleInitBean);
    }

    private final void s1(String tagName) {
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagName.set(tagName);
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        qCirclePolymerizationBean.setFromReportBean(getReportBean().m466clone());
        qCirclePolymerizationBean.setPolymerizationType(7);
        qCirclePolymerizationBean.setExt1From(3);
        com.tencent.biz.qqcircle.launcher.c.G(m0(), qCirclePolymerizationBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(Integer authType) {
        ImageView imageView = null;
        if (authType != null && authType.intValue() == 0) {
            ImageView imageView2 = this.authIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        if (authType != null) {
            int intValue = authType.intValue();
            ImageView imageView3 = this.authIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
            String c16 = com.tencent.biz.qqcircle.immersive.utils.p.c(intValue);
            ImageView imageView4 = this.authIcon;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authIcon");
                imageView4 = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView4.getLayoutParams();
            Option requestHeight = Option.obtain().setUrl(c16).setRequestWidth(layoutParams.width).setRequestHeight(layoutParams.height);
            ImageView imageView5 = this.authIcon;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authIcon");
            } else {
                imageView = imageView5;
            }
            Option targetView = requestHeight.setTargetView(imageView);
            targetView.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v1() {
        Size a16 = com.tencent.biz.qqcircle.immersive.utils.n.a(m0(), R.dimen.c__);
        QCircleAvatarView qCircleAvatarView = this.avatarView;
        if (qCircleAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qCircleAvatarView = null;
        }
        qCircleAvatarView.setUser(((FeedCloudMeta$StFeed) this.f85017h).poster.get(), a16);
    }

    private final void w1() {
        String str;
        Object b16 = this.E.b("KEY_LINEAR_FEED_CONTENT_TYPE");
        if (b16 instanceof String) {
            str = (String) b16;
        } else {
            str = null;
        }
        if (str != null) {
            this.contentType = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x1() {
        Boolean bool;
        String str = ((FeedCloudMeta$StFeed) this.f85017h).content.get();
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = null;
        if (TextUtils.isEmpty(str)) {
            QFSExpandableAsyncTextView qFSExpandableAsyncTextView2 = this.descTv;
            if (qFSExpandableAsyncTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descTv");
            } else {
                qFSExpandableAsyncTextView = qFSExpandableAsyncTextView2;
            }
            qFSExpandableAsyncTextView.setVisibility(8);
            return;
        }
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView3 = this.descTv;
        if (qFSExpandableAsyncTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView3 = null;
        }
        qFSExpandableAsyncTextView3.setVisibility(0);
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView4 = this.descTv;
        if (qFSExpandableAsyncTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView4 = null;
        }
        qFSExpandableAsyncTextView4.setSpecialClickAreaColor(R.color.qui_common_text_link_selector);
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView5 = this.descTv;
        if (qFSExpandableAsyncTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView5 = null;
        }
        qFSExpandableAsyncTextView5.setNeedSpecialAreaBold(false);
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView6 = this.descTv;
        if (qFSExpandableAsyncTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView6 = null;
        }
        qFSExpandableAsyncTextView6.setNeedSpecialHashTagAreaBackground(false);
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView7 = this.descTv;
        if (qFSExpandableAsyncTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView7 = null;
        }
        qFSExpandableAsyncTextView7.setOnClickAtTextListener(new RFWAsyncRichTextView.OnClickAtTextListener() { // from class: m40.p
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
            public final void onClick(String str2) {
                s.y1(s.this, str2);
            }
        });
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView8 = this.descTv;
        if (qFSExpandableAsyncTextView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView8 = null;
        }
        qFSExpandableAsyncTextView8.setOnClickHashTagTextListener(new RFWAsyncRichTextView.OnClickHashTagTextListener() { // from class: m40.q
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
            public final void onClick(String str2) {
                s.z1(s.this, str2);
            }
        });
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView9 = this.descTv;
        if (qFSExpandableAsyncTextView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView9 = null;
        }
        qFSExpandableAsyncTextView9.setCollapseCollapseListener(new c());
        Object b16 = this.E.b("KEY_LINEAR_FEED_DESC_IS_EXPANDED");
        if (b16 instanceof Boolean) {
            bool = (Boolean) b16;
        } else {
            bool = null;
        }
        if (bool == null) {
            boolean areEqual = Intrinsics.areEqual(this.contentType, "article");
            QFSExpandableAsyncTextView qFSExpandableAsyncTextView10 = this.descTv;
            if (qFSExpandableAsyncTextView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descTv");
                qFSExpandableAsyncTextView10 = null;
            }
            qFSExpandableAsyncTextView10.setExpanded(areEqual);
        } else {
            QFSExpandableAsyncTextView qFSExpandableAsyncTextView11 = this.descTv;
            if (qFSExpandableAsyncTextView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descTv");
                qFSExpandableAsyncTextView11 = null;
            }
            qFSExpandableAsyncTextView11.setExpanded(bool.booleanValue());
        }
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView12 = this.descTv;
        if (qFSExpandableAsyncTextView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView12 = null;
        }
        qFSExpandableAsyncTextView12.setText(str);
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView13 = this.descTv;
        if (qFSExpandableAsyncTextView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
        } else {
            qFSExpandableAsyncTextView = qFSExpandableAsyncTextView13;
        }
        qFSExpandableAsyncTextView.setShowCollapse(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(s this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(str);
        qCircleInitBean.setFromReportBean(this$0.getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(this$0.m0(), qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(s this$0, String hashTag) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hashTag, "hashTag");
        this$0.s1(hashTag);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.f56892lu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_user_avatar)");
        this.avatarView = (QCircleAvatarView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f365814y);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qfs_desc_text)");
        this.descTv = (QFSExpandableAsyncTextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f42111iw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qfs_follow_view)");
        this.followView = (QFSFollowView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f39221b3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.qfs_feed_auth_icon)");
        this.authIcon = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f494322o);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.qfs_poster_nick)");
        this.posterNick = (QFSVipNickNameAndIconView) findViewById5;
        QCircleAvatarView qCircleAvatarView = this.avatarView;
        if (qCircleAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qCircleAvatarView = null;
        }
        qCircleAvatarView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f56892lu) {
            r1();
            R0(4, 2, r(), "");
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull FeedCloudMeta$StFeed data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.L0(data, position);
        w1();
        v1();
        B1();
        x1();
        A1();
        p1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLinearFeedWidgetPresenter";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"m40/s$d", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView$d;", "", "state", "", "c", NodeProps.ON_CLICK, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements QFSFollowView.d {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int state) {
            QFSFollowView qFSFollowView = s.this.followView;
            QFSFollowView qFSFollowView2 = null;
            if (qFSFollowView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followView");
                qFSFollowView = null;
            }
            VideoReport.setElementId(qFSFollowView, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "follow");
            hashMap.put("xsj_feed_id", ((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) s.this).f85017h).f398449id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, ((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) s.this).f85017h).poster.f398463id.get());
            hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(((QFSBaseFeedChildPresenter) s.this).f85018i + 1));
            hashMap.putAll(s.this.q1());
            QFSFollowView qFSFollowView3 = s.this.followView;
            if (qFSFollowView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followView");
            } else {
                qFSFollowView2 = qFSFollowView3;
            }
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, qFSFollowView2, hashMap);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int state) {
        }
    }
}
