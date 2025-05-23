package ah;

import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yo.d;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lah/c;", "Lvg/a;", "", "J", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "iconImageView", "G", "Ljava/lang/String;", "getDefaultIconUrl", "()Ljava/lang/String;", "setDefaultIconUrl", "(Ljava/lang/String;)V", "defaultIconUrl", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView iconImageView;

    /* renamed from: G, reason: from kotlin metadata */
    private String defaultIconUrl = "";

    private final String J() {
        if (TextUtils.isEmpty(this.defaultIconUrl)) {
            this.defaultIconUrl = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_feed_robot_icon_url", "https://downv6.qq.com/innovate/guild/robot/robotLogo_mini.png");
        }
        return this.defaultIconUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess()) {
            Animatable animatable = option.getAnimatable();
            r01.c cVar = animatable instanceof r01.c ? (r01.c) animatable : null;
            if (cVar != null) {
                cVar.setLoopCount(1);
                cVar.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(BusinessFeedData feedData, c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = "mqqapi://trooprobot/show_card?uin=" + feedData.getUser().uin;
        ImageView imageView = this$0.iconImageView;
        d.c(str, imageView != null ? imageView.getContext() : null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected void A(final BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if ((feedData.getUser().eUserTypeReport & 64) == 0) {
            ImageView imageView = this.iconImageView;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.iconImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(J()).setTargetView(this.iconImageView), new IPicLoadStateListener() { // from class: ah.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                c.K(loadState, option);
            }
        });
        ImageView imageView3 = this.iconImageView;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: ah.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.L(BusinessFeedData.this, this, view);
                }
            });
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.iconImageView = (ImageView) containerView.findViewById(R.id.f162927nd2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedHeadRobotPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nog;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
