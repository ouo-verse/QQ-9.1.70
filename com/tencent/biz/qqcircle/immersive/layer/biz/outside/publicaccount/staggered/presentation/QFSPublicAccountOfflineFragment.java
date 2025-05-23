package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.chats.api.IChatApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0014J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountOfflineFragment;", "Lcom/tencent/biz/qqcircle/fragments/QCircleBaseFragment;", "", "initTitleBar", "th", "Landroid/widget/ImageView;", "view", "", "url", "vh", "rh", "", "getContentLayoutId", "getLogTag", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "", "onBackEvent", "getDaTongPageId", "onResume", "getPageId", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "backIcon", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "titleText", "E", "contentIv", UserInfo.SEX_FEMALE, "ivBackground", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "G", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "btn", "<init>", "()V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountOfflineFragment extends QCircleBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView backIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView titleText;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView contentIv;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView ivBackground;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIButton btn;

    private final void initTitleBar() {
        View findViewById = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.a4a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.back_icon)");
        ImageView imageView = (ImageView) findViewById;
        this.backIcon = imageView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backIcon");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountOfflineFragment.uh(QFSPublicAccountOfflineFragment.this, view);
            }
        });
        View findViewById2 = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f166992jq2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.title_text)");
        TextView textView2 = (TextView) findViewById2;
        this.titleText = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
        } else {
            textView = textView2;
        }
        textView.setText(uq3.c.W2());
    }

    private final void rh() {
        View findViewById = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f497023e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026ic_account_bottom_i_know)");
        QUIButton qUIButton = (QUIButton) findViewById;
        this.btn = qUIButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountOfflineFragment.sh(QFSPublicAccountOfflineFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(QFSPublicAccountOfflineFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void th() {
        View findViewById = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f497423i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026count_content_background)");
        ImageView imageView = (ImageView) findViewById;
        this.ivBackground = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBackground");
            imageView = null;
        }
        String url = QCircleSkinHelper.getInstance().getUrl(getContext(), "qvideo_skin_qqduanship_bg");
        Intrinsics.checkNotNullExpressionValue(url, "getInstance().getUrl(con\u2026VIDEO_SKIN_QQDUANSHIP_BG)");
        vh(imageView, url);
        View findViewById2 = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f497823m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026ublic_account_iv_content)");
        ImageView imageView3 = (ImageView) findViewById2;
        this.contentIv = imageView3;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentIv");
        } else {
            imageView2 = imageView3;
        }
        String url2 = QCircleSkinHelper.getInstance().getUrl(getContext(), "qvideo_skin_qqduanship_gzh_details");
        Intrinsics.checkNotNullExpressionValue(url2, "getInstance().getUrl(con\u2026N_QQDUANSHIP_GZH_DETAILS)");
        vh(imageView2, url2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(QFSPublicAccountOfflineFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void vh(ImageView view, String url) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(view).setUrl(url).setPredecode(true));
        QLog.d("QFSPublicAccountOfflineFragment", 1, "[loadPic] url: " + url);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168738go3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPublicAccountOfflineFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 306;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        activity.finish();
        IChatApi iChatApi = (IChatApi) QRoute.api(IChatApi.class);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        iChatApi.overrideActivityAnimation((Activity) context, false);
        return true;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QFSQUIUtilsKt.i(getActivity(), R.color.qui_common_bg_nav_secondary);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreatedAfterPartInit(view, savedInstanceState);
        initTitleBar();
        th();
        rh();
    }
}
