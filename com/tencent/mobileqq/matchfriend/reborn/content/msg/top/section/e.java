package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.QQStrangerMsgBaseSection;
import com.tencent.mobileqq.matchfriend.reborn.utils.n;
import com.tencent.mobileqq.matchfriend.reborn.utils.r;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0014J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/section/e;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/QQStrangerMsgBaseSection;", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "Landroid/content/Context;", "context", "", "url", "", "v", "", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", HippyTKDListViewAdapter.X, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "fgIv", "<init>", "()V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends QQStrangerMsgBaseSection<Prompt$CardInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView fgIv;

    private final void v(Context context, String url) {
        if (url == null || url.length() == 0) {
            return;
        }
        try {
            if (w(url)) {
                Intent intent = new Intent();
                intent.putExtra("url", url);
                RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
            } else {
                QLog.d("QQStrangerMsgOperationSection", 1, "jump scheme ret:" + ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, url));
            }
        } catch (Exception e16) {
            QLog.e("QQStrangerMsgOperationSection", 1, "handleJump exception ", e16);
        }
    }

    private final boolean w(String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
            if (!startsWith$default2) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(e this$0, Prompt$CardInfo data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.v(context, data.jump_url.get());
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "it.context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.c(aVar, context2, "em_kl_operation_act_card", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        n nVar = n.f245488a;
        Context context = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        containerView.setBackgroundResource(nVar.a(context) ? R.drawable.f8j : R.drawable.f8k);
        r.c(containerView, 0.0f, 1, null);
        View findViewById = containerView.findViewById(R.id.okq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.iv_fg)");
        this.fgIv = (ImageView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(final Prompt$CardInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        String str = data.background.get();
        ImageView imageView = null;
        if (!(str == null || str.length() == 0)) {
            try {
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Option obtain = Option.obtain();
                ImageView imageView2 = this.fgIv;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fgIv");
                } else {
                    imageView = imageView2;
                }
                Option failDrawable = obtain.setTargetView(imageView).setUrl(data.background.get()).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
                Intrinsics.checkNotNullExpressionValue(failDrawable, "obtain().setTargetView(f\u2026wable(Color.TRANSPARENT))");
                qQPicLoader.e(failDrawable, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section.c
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        e.y(loadState, option);
                    }
                });
            } catch (Exception e16) {
                QLog.e("QQStrangerMsgOperationSection", 1, "loadImage exception ", e16);
            }
        } else {
            ImageView imageView3 = this.fgIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fgIv");
                imageView3 = null;
            }
            imageView3.setImageDrawable(null);
        }
        View view = this.mRootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.z(e.this, data, view2);
                }
            });
        }
        View view2 = this.mRootView;
        if (view2 != null) {
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.e(aVar, context, "em_kl_operation_act_card", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(LoadState loadState, Option option) {
        boolean z16 = false;
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        }
        if (z16) {
            Animatable animatable = option != null ? option.getAnimatable() : null;
            r01.c cVar = animatable instanceof r01.c ? (r01.c) animatable : null;
            if (cVar != null) {
                QLog.d("QQStrangerMsgOperationSection", 1, "onBindData start libra animatable");
                cVar.setLoopCount(65535);
                cVar.start();
            }
        }
    }
}
