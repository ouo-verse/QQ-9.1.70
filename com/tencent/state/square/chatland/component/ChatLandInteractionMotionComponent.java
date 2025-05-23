package com.tencent.state.square.chatland.component;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.MapItem;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.UserFormatKt;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.chatland.component.IChatLandEventListener;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.view.InterMotionIndicatorInfo;
import com.tencent.state.square.chatland.view.chatLandChooseActionDialog.ActionDialog;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareJudgeRecordData;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.MeResourceRecorder;
import com.tencent.state.square.resource.MeResourceRecorderKt;
import com.tencent.state.square.resource.RecordRequest;
import com.tencent.state.template.data.Dpi;
import com.tencent.state.template.data.InterResourceInfo;
import com.tencent.state.template.data.InterSenderInfo;
import com.tencent.state.template.data.InteractionMotionAction;
import com.tencent.state.template.data.InteractionMotionDataParserKt;
import com.tencent.state.template.data.InteractionMotionState;
import com.tencent.state.template.data.InviteInfo;
import com.tencent.state.template.data.User;
import com.tencent.state.template.push.RefreshType;
import com.tencent.state.template.service.InviteRsp;
import com.tencent.state.template.service.VasSquareRoomInteractionService;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014JA\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00192!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J&\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00140\u001bH\u0002J(\u0010$\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\rH\u0002J\u0006\u0010+\u001a\u00020\u0014J\n\u0010,\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010#2\u0006\u0010*\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\u0014H\u0016J\u001a\u0010/\u001a\u00020\u00142\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0016J\u0016\u00104\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\rJ\u0016\u00106\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\rJ\u000e\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000209J&\u0010:\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u0004J\u0006\u0010=\u001a\u00020\u0014J\u0016\u0010>\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bJ&\u0010?\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020A2\u0006\u0010&\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rJ\b\u0010B\u001a\u00020\u0014H\u0016J\u0010\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u0007H\u0016J\u000e\u0010E\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\rJ,\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140JJ\u0018\u0010K\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\r2\u0006\u0010L\u001a\u00020MH\u0002J&\u0010N\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0002J\u001a\u0010O\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u000b2\b\u0010P\u001a\u0004\u0018\u00010#H\u0002J \u0010Q\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006S"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandInteractionMotionComponent;", "Lcom/tencent/state/square/chatland/component/ChatLandMapBaseComponent;", "Lcom/tencent/state/square/chatland/component/IChatLandEventListener;", "appId", "", "(I)V", "beforeMeEndFocusUser", "Lcom/tencent/state/template/data/User;", "isReplyInviting", "", "myInvitingBillNo", "", "myInvitingUin", "", "Ljava/lang/Long;", "recorder", "Lcom/tencent/state/square/resource/MeResourceRecorder;", "service", "Lcom/tencent/state/template/service/VasSquareRoomInteractionService;", "cancelInvite", "", "checkIsNeedRecordAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "uins", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "needRecord", "clearInviteStatus", "doLoadAndShowInteractionAvatar", "billNo", "onSuccess", "Lcom/tencent/state/template/data/InterResourceInfo;", "doRecordAvatar", "res", "sender", "Lcom/tencent/state/square/record/UserIdentifier;", "receiver", "doShowNormalAvatar", "uin", "endInteraction", "getCurrentInteraction", "getInteractionByUin", "onBeforeMeEndFocus", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onInteractionEnd", "partnerUin", "onInteractionInviteCanceled", "onInteractionInviteReceived", "info", "Lcom/tencent/state/template/data/InviteInfo;", "onInteractionInviteSent", "tips", "countdown", "onInteractionInviteTimeout", "onInteractionStart", "onInteractionUserRefresh", "type", "Lcom/tencent/state/template/push/RefreshType;", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "openInviteDialog", "replyInvite", "inviteInfo", "agree", "ignore7Days", "Lkotlin/Function0;", "sendInvite", "interMotion", "Lcom/tencent/state/template/data/InteractionMotionAction;", "tryRecordAvatar", "updateInteractionItem", "result", "updateResourceAfterRecord", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandInteractionMotionComponent extends ChatLandMapBaseComponent implements IChatLandEventListener {
    private static final String TAG = "ChatLandInteractionMotionComponent";
    private User beforeMeEndFocusUser;
    private boolean isReplyInviting;
    private String myInvitingBillNo;
    private Long myInvitingUin;
    private MeResourceRecorder recorder;
    private final VasSquareRoomInteractionService service;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RefreshType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RefreshType.REFRESH_DEFAULT.ordinal()] = 1;
            iArr[RefreshType.REFRESH_INTER_MOTION.ordinal()] = 2;
        }
    }

    public ChatLandInteractionMotionComponent(int i3) {
        super(i3);
        this.service = new VasSquareRoomInteractionService(i3);
        this.recorder = new MeResourceRecorder();
    }

    private final void checkIsNeedRecordAvatar(Resource resource, List<Long> uins, final Function1<? super Boolean, Unit> callback) {
        SquareBaseKt.getSquareLog().d(TAG, "checkIsNeedRecordAvatar: " + resource + ", " + uins);
        VasStatusSquareService.INSTANCE.isMotionNeedRecord(resource, uins, new ResultCallback<SquareJudgeRecordData>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$checkIsNeedRecordAvatar$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ChatLandInteractionMotionComponent", "checkIsNeedRecordAvatar check isMotionNeedRecord failed: " + error + ", " + message, null, 4, null);
                Function1.this.invoke(Boolean.TRUE);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SquareJudgeRecordData result) {
                Intrinsics.checkNotNullParameter(result, "result");
                SquareBaseKt.getSquareLog().d("ChatLandInteractionMotionComponent", "checkIsNeedRecordAvatar check isMotionNeedRecord success: " + result);
                Function1.this.invoke(Boolean.valueOf(result.isRecorded() ^ true));
            }
        });
    }

    private final void doLoadAndShowInteractionAvatar(String billNo, final Function1<? super InterResourceInfo, Unit> onSuccess) {
        SquareBaseKt.getSquareLog().d(TAG, "doLoadAndShowInteractionAvatar: " + billNo);
        this.service.refreshUserInfo(billNo, new ResultCallback<InterResourceInfo>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$doLoadAndShowInteractionAvatar$2
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(InterResourceInfo result) {
                Intrinsics.checkNotNullParameter(result, "result");
                ChatLandInteractionMotionComponent.this.updateInteractionItem(String.valueOf(result.getSenderInfo().getUin()), result);
                ChatLandInteractionMotionComponent.this.updateInteractionItem(String.valueOf(result.getReceiverInfo().getUin()), result);
                onSuccess.invoke(result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doRecordAvatar(final String billNo, Resource res, final UserIdentifier sender, final UserIdentifier receiver) {
        List<UserIdentifier> listOf;
        SquareBaseKt.getSquareLog().d(TAG, "doRecordAvatar: billNo=" + billNo + ", res=" + res + ", sender=" + sender + ", receiver=" + receiver);
        MeResourceRecorder meResourceRecorder = this.recorder;
        RecordRequest recordRequest$default = MeResourceRecorderKt.toRecordRequest$default(res, null, getAppId(), 1, null);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(receiver);
        meResourceRecorder.startRecord(recordRequest$default, sender, listOf, new IResourceCallback() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$doRecordAvatar$1
            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onFirstFrame() {
                IResourceCallback.DefaultImpls.onFirstFrame(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayEnd() {
                IResourceCallback.DefaultImpls.onPlayEnd(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayError(int i3) {
                IResourceCallback.DefaultImpls.onPlayError(this, i3);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayStart() {
                IResourceCallback.DefaultImpls.onPlayStart(this);
            }

            @Override // com.tencent.state.square.resource.IResourceCallback
            public void onRecordError(int type, RecordRequest request, int errorCode) {
                Intrinsics.checkNotNullParameter(request, "request");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ChatLandInteractionMotionComponent", "doRecordAvatar record fail " + errorCode, null, 4, null);
            }

            @Override // com.tencent.state.square.resource.IResourceCallback
            public void onRecordStart(Resource resource, boolean isStarted) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                SquareBaseKt.getSquareLog().i("ChatLandInteractionMotionComponent", "doRecordAvatar startRecord");
            }

            @Override // com.tencent.state.square.resource.IResourceCallback
            public void onRecordSuccess(RecordRequest request) {
                Intrinsics.checkNotNullParameter(request, "request");
                if (request.getResource() == null) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ChatLandInteractionMotionComponent", "doRecordAvatar record fail resource is null,", null, 4, null);
                    return;
                }
                SquareBaseKt.getSquareLog().i("ChatLandInteractionMotionComponent", "doRecordAvatar record success " + request.getResource());
                ChatLandInteractionMotionComponent.this.updateResourceAfterRecord(billNo, Long.parseLong(sender.getUin()), request.getResource());
                ChatLandInteractionMotionComponent.this.updateResourceAfterRecord(billNo, Long.parseLong(receiver.getUin()), request.getResource());
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onRemovedListener() {
                IResourceCallback.DefaultImpls.onRemovedListener(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticFailed() {
                IResourceCallback.DefaultImpls.onStaticFailed(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticSuccess() {
                IResourceCallback.DefaultImpls.onStaticSuccess(this);
            }
        });
    }

    private final void doShowNormalAvatar(long uin) {
        SquareBaseKt.getSquareLog().d(TAG, "doShowNormalAvatar: " + uin);
        updateInteractionItem(String.valueOf(uin), null);
    }

    private final InterResourceInfo getCurrentInteraction() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ChatLandAvatarItem meAvatarItemData;
        User user;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
        if (chatLandSquareComponent == null || (meAvatarItemData = chatLandSquareComponent.getMeAvatarItemData()) == null || (user = meAvatarItemData.getUser()) == null) {
            return null;
        }
        return user.getInteraction();
    }

    private final InterResourceInfo getInteractionByUin(long uin) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ChatLandAvatarItem avatarItemDataByUin;
        User user;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
        if (chatLandSquareComponent == null || (avatarItemDataByUin = chatLandSquareComponent.getAvatarItemDataByUin(uin)) == null || (user = avatarItemDataByUin.getUser()) == null) {
            return null;
        }
        return user.getInteraction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendInvite(final long uin, final InteractionMotionAction interMotion) {
        SquareBaseKt.getSquareLog().d(TAG, "sendInvite: " + uin + ", " + interMotion);
        this.service.sendInvite(uin, interMotion.getMotionId(), new ResultCallback<InviteRsp>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$sendInvite$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
            }

            /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
            @Override // com.tencent.state.service.ResultCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResultFailure(int error, String message, String prompt) {
                boolean z16;
                VasBaseFragment fragment;
                boolean isBlank;
                ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                if (prompt != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(prompt);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                            fragment = ChatLandInteractionMotionComponent.this.getFragment();
                            squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, prompt, 0);
                            return;
                        }
                        return;
                    }
                }
                z16 = true;
                if (z16) {
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(InviteRsp result) {
                List listOf;
                VasBaseFragment fragment;
                Intrinsics.checkNotNullParameter(result, "result");
                ChatLandInteractionMotionComponent.this.onInteractionInviteSent(result.getBillNo(), uin, result.getTips(), (int) result.getCountdown());
                Resource resource = new Resource(interMotion.getMotionId(), null, null, Dpi.formatSize$default(interMotion.getDpi().getShowDpi(), false, 1, null), Dpi.formatSize$default(interMotion.getDpi().getRecordDpi(), false, 1, null), false, null, 1, InteractionMotionDataParserKt.toInt(interMotion.getStyleType()), null, 614, null);
                UserFormatKt.filamentFill(resource, interMotion.getFilament());
                ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = ChatLandInteractionMotionComponent.this;
                String billNo = result.getBillNo();
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Long[]{Long.valueOf(Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin())), Long.valueOf(uin)});
                chatLandInteractionMotionComponent.tryRecordAvatar(billNo, resource, listOf);
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                fragment = ChatLandInteractionMotionComponent.this.getFragment();
                squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, "\u5df2\u5411\u5bf9\u65b9\u53d1\u9001\u9080\u8bf7\uff0c\u7b49\u5f85\u63a5\u53d7", 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryRecordAvatar(final String billNo, final Resource resource, List<Long> uins) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        ChatLandAvatarItem avatarItemDataByUin;
        ChatLandAvatarItem avatarItemDataByUin2;
        SquareBaseKt.getSquareLog().d(TAG, "tryRecordAvatar: " + resource + ", " + uins);
        if (uins.size() != 2) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "tryRecordAvatar: uins size error", null, 4, null);
            return;
        }
        boolean z16 = this instanceof VasBaseFragmentComponentGroup;
        UserIdentifier userIdentifier = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
        final UserIdentifier userIdentifier2 = (chatLandSquareComponent == null || (avatarItemDataByUin2 = chatLandSquareComponent.getAvatarItemDataByUin(uins.get(0).longValue())) == null) ? null : avatarItemDataByUin2.toUserIdentifier();
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup4 == null || (component$default2 = vasBaseFragmentComponentGroup4.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent2 = (ChatLandSquareComponent) component$default2;
        if (chatLandSquareComponent2 != null && (avatarItemDataByUin = chatLandSquareComponent2.getAvatarItemDataByUin(uins.get(1).longValue())) != null) {
            userIdentifier = avatarItemDataByUin.toUserIdentifier();
        }
        final UserIdentifier userIdentifier3 = userIdentifier;
        if (userIdentifier2 != null && userIdentifier3 != null) {
            checkIsNeedRecordAvatar(resource, uins, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$tryRecordAvatar$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17) {
                    SquareBaseKt.getSquareLog().d("ChatLandInteractionMotionComponent", "tryRecordAvatar: " + z17);
                    if (z17) {
                        ChatLandInteractionMotionComponent.this.doRecordAvatar(billNo, resource, userIdentifier2, userIdentifier3);
                    }
                }
            });
            return;
        }
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "tryRecordAvatar: sender or receiver not found, senderItem: " + userIdentifier2 + ", receiverItem: " + userIdentifier3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateInteractionItem(String uin, InterResourceInfo result) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        WeakReference<VasBaseFragmentComponentGroup> parent3;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default3;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3;
        SquareBaseKt.getSquareLog().d(TAG, "updateInteractionItem: " + uin);
        boolean z16 = this instanceof VasBaseFragmentComponentGroup;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup4 == null || (component$default = vasBaseFragmentComponentGroup4.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
        int indexByUinType$default = chatLandSquareComponent != null ? ChatLandSquareComponent.getIndexByUinType$default(chatLandSquareComponent, uin, 0, 2, null) : -1;
        if (indexByUinType$default != -1) {
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup5 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
            if ((vasBaseFragmentComponentGroup5 == null || (component$default2 = vasBaseFragmentComponentGroup5.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandSquareComponent.class, null, null, 6, null) : null;
            }
            ChatLandSquareComponent chatLandSquareComponent2 = (ChatLandSquareComponent) component$default2;
            MapItem itemDataByIndex = chatLandSquareComponent2 != null ? chatLandSquareComponent2.getItemDataByIndex(indexByUinType$default) : null;
            if (!(itemDataByIndex instanceof ChatLandAvatarItem)) {
                itemDataByIndex = null;
            }
            ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) itemDataByIndex;
            if (chatLandAvatarItem != null) {
                chatLandAvatarItem.getUser().setInteraction(result);
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup6 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
                if ((vasBaseFragmentComponentGroup6 == null || (fragmentComponent = vasBaseFragmentComponentGroup6.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent3 = getParent()) == null || (vasBaseFragmentComponentGroup3 = parent3.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup3.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment5 = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment5 == null || (component$default3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment5, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment6 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment6 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment6, ChatLandSquareComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default3;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                ChatLandSquareComponent chatLandSquareComponent3 = (ChatLandSquareComponent) fragmentComponent;
                if (chatLandSquareComponent3 != null) {
                    chatLandSquareComponent3.updateByIndex(indexByUinType$default, chatLandAvatarItem);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateResourceAfterRecord(String billNo, long uin, Resource resource) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ChatLandAvatarItem avatarItemDataByUin;
        SquareBaseKt.getSquareLog().d(TAG, "updateResourceAfterRecord: " + billNo + ", " + uin);
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
        if (chatLandSquareComponent == null || (avatarItemDataByUin = chatLandSquareComponent.getAvatarItemDataByUin(uin)) == null) {
            return;
        }
        InterResourceInfo interaction = avatarItemDataByUin.getUser().getInteraction();
        if (Intrinsics.areEqual(interaction != null ? interaction.getBillNo() : null, billNo)) {
            updateInteractionItem(avatarItemDataByUin.getUser().getUin(), InterResourceInfo.copy$default(interaction, null, InterSenderInfo.copy$default(interaction.getSenderInfo(), resource, null, 0L, 6, null), null, 5, null));
        }
    }

    public final void cancelInvite() {
        SquareBaseKt.getSquareLog().i(TAG, "cancelInvite " + this.myInvitingBillNo);
        String str = this.myInvitingBillNo;
        if (str != null) {
            this.service.cancelInvite(str, new ResultCallback<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$cancelInvite$$inlined$let$lambda$1
                /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
                @Override // com.tencent.state.service.ResultCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResultFailure(int error, String message, String prompt) {
                    boolean z16;
                    VasBaseFragment fragment;
                    boolean isBlank;
                    ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                    if (prompt != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(prompt);
                        if (!isBlank) {
                            z16 = false;
                            if (z16) {
                                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                                fragment = ChatLandInteractionMotionComponent.this.getFragment();
                                squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, prompt, 0);
                                return;
                            }
                            return;
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(Unit result) {
                    WeakReference<VasBaseFragmentComponentGroup> parent;
                    VasBaseFragment vasBaseFragment;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    VasBaseFragment fragment;
                    Intrinsics.checkNotNullParameter(result, "result");
                    ChatLandInteractionMotionComponent.this.myInvitingBillNo = null;
                    ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = ChatLandInteractionMotionComponent.this;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandInteractionMotionComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandInteractionMotionComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && (((parent = chatLandInteractionMotionComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) chatLandInteractionMotionComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null))) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandInteractionMotionComponent).parentFragment;
                        component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null) : null;
                    }
                    ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) component$default;
                    if (chatLandUiComponent != null) {
                        chatLandUiComponent.hideIndicator();
                    }
                    ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                    fragment = ChatLandInteractionMotionComponent.this.getFragment();
                    ICommonUtils.DefaultImpls.showToastSafely$default(squareCommon, fragment != null ? fragment.requireContext() : null, "\u5df2\u53d6\u6d88\u5408\u4f53\u9080\u8bf7", 0, 4, null);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    ChatLandInteractionMotionComponent.this.myInvitingBillNo = null;
                }
            });
        }
    }

    public final void endInteraction() {
        final String billNo;
        InterResourceInfo currentInteraction = getCurrentInteraction();
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("endInteraction ");
        sb5.append(currentInteraction != null ? currentInteraction.getBillNo() : null);
        squareLog.i(TAG, sb5.toString());
        if (currentInteraction == null || (billNo = currentInteraction.getBillNo()) == null) {
            return;
        }
        final Long partnerUin = currentInteraction.partnerUin(Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin()));
        this.service.endInteraction(billNo, new ResultCallback<String>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$endInteraction$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
            }

            /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
            @Override // com.tencent.state.service.ResultCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResultFailure(int error, String message, String prompt) {
                boolean z16;
                VasBaseFragment fragment;
                boolean isBlank;
                ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                if (prompt != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(prompt);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                            fragment = ChatLandInteractionMotionComponent.this.getFragment();
                            squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, prompt, 0);
                            return;
                        }
                        return;
                    }
                }
                z16 = true;
                if (z16) {
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(String result) {
                boolean isBlank;
                VasBaseFragment fragment;
                Intrinsics.checkNotNullParameter(result, "result");
                isBlank = StringsKt__StringsJVMKt.isBlank(result);
                if (isBlank) {
                    result = "\u5408\u4f53\u7ed3\u675f";
                }
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                fragment = ChatLandInteractionMotionComponent.this.getFragment();
                squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, result, 0);
                ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = ChatLandInteractionMotionComponent.this;
                String str = billNo;
                Long l3 = partnerUin;
                chatLandInteractionMotionComponent.onInteractionEnd(str, l3 != null ? l3.longValue() : 0L);
            }
        });
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandLeaveRoom() {
        IChatLandEventListener.DefaultImpls.onChatLandLeaveRoom(this);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandSeatAdded() {
        IChatLandEventListener.DefaultImpls.onChatLandSeatAdded(this);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        this.recorder.onDestroy();
    }

    public final void onInteractionEnd(String billNo, long partnerUin) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        SquareBaseKt.getSquareLog().d(TAG, "onInteractionEnd: " + billNo);
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.hideIndicator();
        }
        doShowNormalAvatar(Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin()));
        doShowNormalAvatar(partnerUin);
    }

    public final void onInteractionInviteCanceled(String billNo, long uin) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Long l3;
        Context requireContext;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        SquareBaseKt.getSquareLog().d(TAG, "onInteractionInviteCanceled: " + billNo + ", " + uin);
        if (Intrinsics.areEqual(billNo, this.myInvitingBillNo) && (l3 = this.myInvitingUin) != null && uin == l3.longValue()) {
            SquareBaseKt.getSquareLog().d(TAG, "onInteractionInviteCanceled: self invite canceled");
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            VasBaseFragment fragment = getFragment();
            if (fragment == null || (requireContext = fragment.requireContext()) == null) {
                return;
            }
            ICommonUtils.DefaultImpls.showToastSafely$default(squareCommon, requireContext, "\u5bf9\u65b9\u5df2\u7ecf\u79bb\u5f00\u4e86", 0, 4, null);
            clearInviteStatus();
            return;
        }
        SquareBaseKt.getSquareLog().d(TAG, "onInteractionInviteCanceled: other invite canceled");
        ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
        VasBaseFragment fragment2 = getFragment();
        FragmentComponent fragmentComponent2 = null;
        ICommonUtils.DefaultImpls.showToastSafely$default(squareCommon2, fragment2 != null ? fragment2.getContext() : null, "\u5bf9\u65b9\u53d6\u6d88\u4e86\u5408\u4f53\u9080\u8bf7", 0, 4, null);
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.hideInvitePanel(billNo);
        }
    }

    public final void onInteractionInviteReceived(InviteInfo info) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(info, "info");
        SquareBaseKt.getSquareLog().d(TAG, "onInteractionInviteReceived: " + info);
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.showInvitePanel(info);
        }
    }

    public final void onInteractionInviteSent(String billNo, long uin, String tips, int countdown) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.myInvitingBillNo = billNo;
        this.myInvitingUin = Long.valueOf(uin);
        SquareBaseKt.getSquareLog().d(TAG, "onInteractionInviteSent: " + billNo);
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.showIndicator(new InterMotionIndicatorInfo(InteractionMotionState.INVITING, billNo, tips, countdown));
        }
    }

    public final void onInteractionInviteTimeout() {
        clearInviteStatus();
    }

    public final void onInteractionStart(String billNo, String tips) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(tips, "tips");
        SquareBaseKt.getSquareLog().d(TAG, "onInteractionStart: " + billNo);
        FragmentComponent fragmentComponent2 = null;
        this.myInvitingBillNo = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.showIndicator(new InterMotionIndicatorInfo(InteractionMotionState.PAIRING, billNo, tips, 0, 8, null));
        }
        doLoadAndShowInteractionAvatar(billNo, new Function1<InterResourceInfo, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$onInteractionStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InterResourceInfo interResourceInfo) {
                invoke2(interResourceInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InterResourceInfo resInfo) {
                List listOf;
                Intrinsics.checkNotNullParameter(resInfo, "resInfo");
                SquareBaseKt.getSquareLog().d("ChatLandInteractionMotionComponent", "onInteractionStart: try re-record: " + resInfo);
                ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = ChatLandInteractionMotionComponent.this;
                String billNo2 = resInfo.getBillNo();
                Resource interactionResource = resInfo.getSenderInfo().getInteractionResource();
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Long[]{Long.valueOf(resInfo.getSenderInfo().getUin()), Long.valueOf(resInfo.getReceiverInfo().getUin())});
                chatLandInteractionMotionComponent.tryRecordAvatar(billNo2, interactionResource, listOf);
            }
        });
    }

    public final void onInteractionUserRefresh(String billNo, RefreshType type, long sender, long receiver) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(type, "type");
        SquareBaseKt.getSquareLog().d(TAG, "onInteractionUserRefresh: " + billNo + ", " + type + ", " + sender + ", " + receiver);
        int i3 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i3 == 1) {
            doShowNormalAvatar(sender);
            doShowNormalAvatar(receiver);
        } else {
            if (i3 != 2) {
                return;
            }
            doLoadAndShowInteractionAvatar$default(this, billNo, null, 2, null);
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusEnd() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        InterResourceInfo interaction;
        User user = this.beforeMeEndFocusUser;
        if (user != null && (interaction = user.getInteraction()) != null) {
            String billNo = interaction.getBillNo();
            Long partnerUin = interaction.partnerUin(Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin()));
            if (partnerUin == null) {
                return;
            } else {
                onInteractionEnd(billNo, partnerUin.longValue());
            }
        }
        if (this.myInvitingBillNo != null) {
            clearInviteStatus();
        }
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null) : null;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) component$default;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.hideInvitePanel(null);
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusStart(User user) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        InterResourceInfo interaction;
        String billNo;
        Intrinsics.checkNotNullParameter(user, "user");
        boolean z16 = this instanceof VasBaseFragmentComponentGroup;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(ChatLandUiComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandUiComponent.class, null, null, 6, null) : null;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) component$default;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.hideIndicator();
        }
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup4 == null || (component$default2 = vasBaseFragmentComponentGroup4.getComponent(ChatLandUiComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandUiComponent.class, null, null, 6, null) : null;
        }
        ChatLandUiComponent chatLandUiComponent2 = (ChatLandUiComponent) component$default2;
        if (chatLandUiComponent2 != null) {
            ChatLandUiComponent.hideInvitePanel$default(chatLandUiComponent2, null, 1, null);
        }
        if (user.getInteraction() == null || (interaction = user.getInteraction()) == null || (billNo = interaction.getBillNo()) == null) {
            return;
        }
        onInteractionStart(billNo, "");
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onPublicChatConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        IChatLandEventListener.DefaultImpls.onPublicChatConfigLoaded(this, conf);
    }

    public final void openInviteDialog(final long uin) {
        Context requireContext;
        SquareBaseKt.getSquareLog().d(TAG, "openInviteDialog: " + uin);
        if (this.myInvitingBillNo != null) {
            SquareBaseKt.getSquareLog().d(TAG, "openInviteDialog: myInvitingBillNo != null");
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            VasBaseFragment fragment = getFragment();
            squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, "\u4f60\u6b63\u5728\u9080\u8bf7\u522b\u4eba\u5408\u4f53", 0);
            return;
        }
        InterResourceInfo currentInteraction = getCurrentInteraction();
        if (currentInteraction != null) {
            Long partnerUin = currentInteraction.partnerUin(Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin()));
            if (partnerUin != null && partnerUin.longValue() == uin) {
                SquareBaseKt.getSquareLog().d(TAG, "openInviteDialog: currentInter.partnerUin == uin");
                ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
                VasBaseFragment fragment2 = getFragment();
                squareCommon2.showToastSafely(fragment2 != null ? fragment2.requireContext() : null, "\u4f60\u4eec\u6b63\u5728\u5408\u4f53\u4e2d\uff01", 0);
                return;
            }
            SquareBaseKt.getSquareLog().d(TAG, "openInviteDialog: getCurrentInteraction() != null");
            ICommonUtils squareCommon3 = SquareBaseKt.getSquareCommon();
            VasBaseFragment fragment3 = getFragment();
            squareCommon3.showToastSafely(fragment3 != null ? fragment3.requireContext() : null, "\u8bf7\u5148\u7ed3\u675f\u5f53\u524d\u5408\u4f53\u52a8\u4f5c\u518d\u53d1\u8d77", 0);
            return;
        }
        if (getInteractionByUin(uin) != null) {
            SquareBaseKt.getSquareLog().d(TAG, "openInviteDialog: getInteractionByUin(uin) != null");
            ICommonUtils squareCommon4 = SquareBaseKt.getSquareCommon();
            VasBaseFragment fragment4 = getFragment();
            squareCommon4.showToastSafely(fragment4 != null ? fragment4.requireContext() : null, "\u5bf9\u65b9\u5df2\u7ecf\u548c\u522b\u4eba\u5408\u4f53\u4e86", 0);
            return;
        }
        VasBaseFragment fragment5 = getFragment();
        if (fragment5 == null || (requireContext = fragment5.requireContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment?.requireContext() ?: return");
        new ActionDialog(requireContext, new ChatLandInteractionMotionComponent$openInviteDialog$1(this.service), new Function1<InteractionMotionAction, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$openInviteDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InteractionMotionAction interactionMotionAction) {
                invoke2(interactionMotionAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InteractionMotionAction it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ChatLandInteractionMotionComponent.this.sendInvite(uin, it);
            }
        }).show();
    }

    public final void replyInvite(final InviteInfo inviteInfo, final boolean agree, boolean ignore7Days, final Function0<Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(inviteInfo, "inviteInfo");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        SquareBaseKt.getSquareLog().d(TAG, "replyInvite: " + inviteInfo + ", " + agree + ", " + ignore7Days);
        if (this.isReplyInviting) {
            SquareBaseKt.getSquareLog().d(TAG, "replyInvite: isReplyInviting");
        } else {
            this.isReplyInviting = true;
            this.service.replyInvite(inviteInfo.getBillNo(), agree, ignore7Days, new ResultCallback<String>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$replyInvite$1
                /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
                @Override // com.tencent.state.service.ResultCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResultFailure(int error, String message, String prompt) {
                    boolean z16;
                    VasBaseFragment fragment;
                    boolean isBlank;
                    ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                    if (prompt != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(prompt);
                        if (!isBlank) {
                            z16 = false;
                            if (z16) {
                                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                                fragment = ChatLandInteractionMotionComponent.this.getFragment();
                                squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, prompt, 0);
                                return;
                            }
                            return;
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(String result) {
                    VasBaseFragment fragment;
                    Intrinsics.checkNotNullParameter(result, "result");
                    ChatLandInteractionMotionComponent.this.isReplyInviting = false;
                    if (agree) {
                        ChatLandInteractionMotionComponent.this.onInteractionStart(inviteInfo.getBillNo(), result);
                        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                        fragment = ChatLandInteractionMotionComponent.this.getFragment();
                        squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, "\u5408\u4f53\u6210\u529f", 2);
                    }
                    onSuccess.invoke();
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    ChatLandInteractionMotionComponent.this.isReplyInviting = false;
                }
            });
        }
    }

    private final void clearInviteStatus() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        FragmentComponent fragmentComponent2 = null;
        this.myInvitingBillNo = null;
        SquareBaseKt.getSquareLog().d(TAG, "onInteractionInviteTimeout");
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
        if (chatLandUiComponent != null) {
            chatLandUiComponent.hideIndicator();
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent
    public void onBeforeMeEndFocus() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ChatLandAvatarItem meAvatarItemData;
        User user;
        User user2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
        if (chatLandSquareComponent != null && (meAvatarItemData = chatLandSquareComponent.getMeAvatarItemData()) != null && (user = meAvatarItemData.getUser()) != null) {
            user2 = user.copy((r24 & 1) != 0 ? user.uin : null, (r24 & 2) != 0 ? user.info : null, (r24 & 4) != 0 ? user.dressKey : null, (r24 & 8) != 0 ? user.status : null, (r24 & 16) != 0 ? user.sitDown : null, (r24 & 32) != 0 ? user.prizeInfo : null, (r24 & 64) != 0 ? user.interaction : null, (r24 & 128) != 0 ? user.relationType : null, (r24 & 256) != 0 ? user.focusAnimationSkin : null, (r24 & 512) != 0 ? user.focusBroadcastSkin : null, (r24 & 1024) != 0 ? user.bubbleSkin : null);
        }
        this.beforeMeEndFocusUser = user2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void doLoadAndShowInteractionAvatar$default(ChatLandInteractionMotionComponent chatLandInteractionMotionComponent, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = new Function1<InterResourceInfo, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent$doLoadAndShowInteractionAvatar$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InterResourceInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InterResourceInfo interResourceInfo) {
                    invoke2(interResourceInfo);
                    return Unit.INSTANCE;
                }
            };
        }
        chatLandInteractionMotionComponent.doLoadAndShowInteractionAvatar(str, function1);
    }
}
