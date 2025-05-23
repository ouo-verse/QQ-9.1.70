package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.framework.LifecycleBoundRunnable;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/StartIntentResolvePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/os/Bundle;", "bundle", "", "z9", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, Constants.FILE_INSTANCE_STATE, "onPartCreate", "", "action", "", "args", "handleBroadcastMessage", "", "d", "Ljava/lang/Integer;", "pendingInteractAction", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class StartIntentResolvePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer pendingInteractAction;

    private final void x9() {
        Integer num = this.pendingInteractAction;
        if (num == null || num.intValue() != 5) {
            return;
        }
        this.pendingInteractAction = null;
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        LifecycleBoundRunnable.Companion companion = LifecycleBoundRunnable.INSTANCE;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        uIHandlerV2.postDelayed(companion.a(lifecycleOwner, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.StartIntentResolvePart$handleStartInputForCommentIntent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StartIntentResolvePart.this.broadcastMessage("message_comment_box_feed", new a.CommentFeedMessage("StartIntentResolvePart", new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_COMMENT_FEED, null, 0, (short) 1, null, 16, null)));
            }
        }), 64L);
    }

    private final void z9(Bundle bundle) {
        this.pendingInteractAction = Integer.valueOf(bundle.getInt("start_intent_interact_action"));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_data_changed_render_on_screen")) {
            x9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        Bundle bundle;
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null || (bundle = intent.getExtras()) == null) {
            bundle = Bundle.EMPTY;
        }
        Intrinsics.checkNotNullExpressionValue(bundle, "activity?.intent?.extras ?: Bundle.EMPTY");
        z9(bundle);
    }
}
