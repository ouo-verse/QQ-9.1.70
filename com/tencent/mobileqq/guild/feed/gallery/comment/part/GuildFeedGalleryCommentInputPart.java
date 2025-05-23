package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedExternalCommentsUpdatedEvent;
import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dl1.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J+\u0010\u0015\u001a\u00020\u00032!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\fH\u0016J\u0012\u0010'\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001e\u0010+\u001a\u0004\u0018\u00010\u001d2\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010,\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010;\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00106R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020=0<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentInputPart;", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/a;", "Landroid/view/View$OnClickListener;", "", "N9", "K9", "", "sourceTag", "P9", "", "hasMediaDraft", "T9", "Landroid/view/View;", "contentView", "O9", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "Lkotlin/ParameterName;", "name", "type", "block", "G9", "v", "M9", "J9", "clickView", "R9", "H9", "I9", "", "msg", "L9", "", "operateType", "S9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "action", "handleBroadcastMessage", "args", "getMessage", NodeProps.ON_CLICK, "f", "Landroid/view/View;", "inputRoot", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "tvInput", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "btnAt", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "btnEmotion", BdhLogUtil.LogTag.Tag_Conn, "mPicEmotion", "Landroid/util/SparseArray;", "Ldl1/b;", "D", "Landroid/util/SparseArray;", "hintProcessorList", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryCommentInputPart extends a implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mPicEmotion;

    /* renamed from: D, reason: from kotlin metadata */
    private SparseArray<dl1.b> hintProcessorList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View inputRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvInput;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView btnAt;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView btnEmotion;

    public GuildFeedGalleryCommentInputPart() {
        super(null, 1, null);
    }

    private final void G9(Function1<? super SpeakPermissionType, Unit> block) {
        GuildMainFrameUtils.l(getGuildId(), false, new GuildFeedGalleryCommentInputPart$getSpeakPermissionAsync$1(this, block));
    }

    private final void H9(View v3) {
        if (com.tencent.mobileqq.guild.util.o.a(v3)) {
            return;
        }
        S9(1);
    }

    private final void I9(View v3) {
        if (com.tencent.mobileqq.guild.util.o.a(v3)) {
            return;
        }
        S9(2);
    }

    private final void J9(View v3) {
        if (com.tencent.mobileqq.guild.util.o.a(v3)) {
            return;
        }
        S9(0);
        R9(v3);
    }

    private final void K9() {
        bl.c().b(new GuildFeedExternalCommentsUpdatedEvent(z9().getFeedId(), z9().getCommentCount() + 1), true);
    }

    private final void L9(Object msg2) {
        if (B9().getAutoShowInputDialog()) {
            Object broadcastGetMessage = broadcastGetMessage("message_get_comment_panel_show", null);
            Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) broadcastGetMessage).booleanValue();
            if (booleanValue) {
                S9(0);
            }
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentInputPart", 1, "checkAutoShowInputDialog isCommentPanelShow:" + booleanValue);
        }
    }

    private final void M9(View v3) {
        if (com.tencent.mobileqq.guild.util.o.a(v3)) {
            return;
        }
        S9(3);
    }

    private final void N9() {
        List<dl1.b> listOf;
        SparseArray<dl1.b> sparseArray = new SparseArray<>();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new dl1.b[]{new dl1.c(), new dl1.g(), new dl1.e(), new dl1.i(), new dl1.h(), new dl1.d(), new dl1.a(), new dl1.f()});
        for (dl1.b bVar : listOf) {
            sparseArray.put(bVar.a(), bVar);
        }
        this.hintProcessorList = sparseArray;
    }

    private final void O9(View contentView) {
        AppInterface appInterface;
        boolean z16;
        IGProGuildInfo guildInfo;
        View findViewById = contentView.findViewById(R.id.vhb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026ery_comment_input_layout)");
        this.inputRoot = findViewById;
        View findViewById2 = contentView.findViewById(R.id.jha);
        TextView textView = (TextView) findViewById2;
        textView.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026mmentInputPart)\n        }");
        this.tvInput = textView;
        View findViewById3 = contentView.findViewById(R.id.tcu);
        ImageView imageView = (ImageView) findViewById3;
        imageView.setOnClickListener(this);
        GuildGalleryCommentPanelParams z95 = z9();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        int i3 = 0;
        if (iGPSService != null && (guildInfo = iGPSService.getGuildInfo(z95.getGuildId())) != null) {
            z16 = guildInfo.isMember();
        } else {
            z16 = false;
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentInputPart", 1, "showInputComponent isMember = " + z16 + " guildid = " + z95.getGuildId());
        if (!z16) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById\u2026 else View.GONE\n        }");
        this.btnAt = imageView;
        View findViewById4 = contentView.findViewById(R.id.ah5);
        ImageView imageView2 = (ImageView) findViewById4;
        imageView2.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById\u2026mmentInputPart)\n        }");
        this.btnEmotion = imageView2;
        View findViewById5 = contentView.findViewById(R.id.tfw);
        ImageView imageView3 = (ImageView) findViewById5;
        imageView3.setOnClickListener(this);
        ho1.b.a(true, imageView3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById\u2026bly(true, this)\n        }");
        this.mPicEmotion = imageView3;
    }

    private final void P9(final String sourceTag) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryCommentInputPart.Q9(GuildFeedGalleryCommentInputPart.this, sourceTag);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(GuildFeedGalleryCommentInputPart this$0, String sourceTag) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sourceTag, "$sourceTag");
        com.tencent.mobileqq.guild.main.d.d(MobileQQ.sMobileQQ.peekAppRuntime(), this$0.z9().getGuildId(), sourceTag);
    }

    private final void R9(View clickView) {
        Map mapOf;
        HashMap hashMap = new HashMap();
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_click_region", 1));
        hashMap.putAll(mapOf);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(clickView, "em_sgrp_forum_comment", "clck", hashMap);
    }

    private final void S9(int operateType) {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentInputPart", 1, "showInputDialog operateType:" + operateType);
        broadcastMessage("message_comment_box_feed", new a.CommentFeedMessage("Guild_Feed_GAL_GuildFeedGalleryCommentInputPart", new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_COMMENT_FEED, null, operateType, (short) 1, null, 16, null)));
    }

    private final void T9(boolean hasMediaDraft) {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentInputPart", 1, "updateHint hasMediaDraft=" + hasMediaDraft);
        if (hasMediaDraft) {
            TextView textView = this.tvInput;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvInput");
                textView = null;
            }
            textView.setText(getContext().getString(R.string.f143950ng));
            return;
        }
        G9(new Function1<SpeakPermissionType, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentInputPart$updateHint$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpeakPermissionType speakPermissionType) {
                invoke2(speakPermissionType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpeakPermissionType it) {
                SparseArray sparseArray;
                TextView textView2;
                Intrinsics.checkNotNullParameter(it, "it");
                sparseArray = GuildFeedGalleryCommentInputPart.this.hintProcessorList;
                if (sparseArray == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hintProcessorList");
                    sparseArray = null;
                }
                dl1.b bVar = (dl1.b) sparseArray.get(it.ordinal());
                if (bVar != null) {
                    textView2 = GuildFeedGalleryCommentInputPart.this.tvInput;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvInput");
                        textView2 = null;
                    }
                    b.a.a(bVar, textView2, null, 2, null);
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@NotNull String action, @Nullable Object msg2) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z16 = false;
        switch (action.hashCode()) {
            case -738605245:
                if (action.equals("message_on_comment_completed") && (msg2 instanceof a.OnCommentCompletedMessage) && ((a.OnCommentCompletedMessage) msg2).getIsSuccess()) {
                    P9("do comment or reply");
                    K9();
                    return;
                }
                return;
            case -202344159:
                if (action.equals("message_action_gallery_comment_input_bar_hide")) {
                    if (msg2 instanceof Boolean) {
                        bool = (Boolean) msg2;
                    } else {
                        bool = null;
                    }
                    if (bool != null) {
                        z16 = bool.booleanValue();
                    }
                    T9(z16);
                    return;
                }
                return;
            case 390249661:
                if (action.equals("message_comment_request_operation_result") && (msg2 instanceof a.CommentRequestOperationResult)) {
                    a.CommentRequestOperationResult commentRequestOperationResult = (a.CommentRequestOperationResult) msg2;
                    if (commentRequestOperationResult.getIsSuccess() && commentRequestOperationResult.getOperationMessage().getOperation() == 2) {
                        P9("do comment or reply");
                        return;
                    }
                    return;
                }
                return;
            case 417561184:
                if (action.equals("message_on_comment_panel_show") && B9().getShowInputOnly()) {
                    S9(0);
                    return;
                }
                return;
            case 1047580686:
                if (action.equals("message_on_reply_completed") && (msg2 instanceof a.OnReplyCommentCompletedMessage) && ((a.OnReplyCommentCompletedMessage) msg2).getIsSuccess()) {
                    P9("do comment or reply");
                    return;
                }
                return;
            case 1309248708:
                if (action.equals("message_comment_panel_open_finish_even")) {
                    L9(msg2);
                    return;
                }
                return;
            case 1751847274:
                if (action.equals("message_reply_request_operation") && (msg2 instanceof a.ReplyRequestOperationResult)) {
                    a.ReplyRequestOperationResult replyRequestOperationResult = (a.ReplyRequestOperationResult) msg2;
                    if (replyRequestOperationResult.getIsSuccess() && replyRequestOperationResult.getOperationMessage().getOperation() == 2) {
                        P9("do comment or reply");
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
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
        if (num != null && num.intValue() == R.id.jha) {
            J9(v3);
        } else if (num != null && num.intValue() == R.id.tcu) {
            H9(v3);
        } else if (num != null && num.intValue() == R.id.ah5) {
            I9(v3);
        } else if (num != null && num.intValue() == R.id.tfw) {
            M9(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        O9(rootView);
        N9();
        G9(new Function1<SpeakPermissionType, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentInputPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpeakPermissionType speakPermissionType) {
                invoke2(speakPermissionType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpeakPermissionType it) {
                SparseArray sparseArray;
                TextView textView;
                Intrinsics.checkNotNullParameter(it, "it");
                sparseArray = GuildFeedGalleryCommentInputPart.this.hintProcessorList;
                if (sparseArray == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hintProcessorList");
                    sparseArray = null;
                }
                dl1.b bVar = (dl1.b) sparseArray.get(it.ordinal());
                if (bVar != null) {
                    textView = GuildFeedGalleryCommentInputPart.this.tvInput;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvInput");
                        textView = null;
                    }
                    b.a.a(bVar, textView, null, 2, null);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
    }
}
