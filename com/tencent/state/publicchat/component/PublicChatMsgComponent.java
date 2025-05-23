package com.tencent.state.publicchat.component;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.event.ChatAddUinToSquare;
import com.tencent.state.publicchat.IPublicChatOwner;
import com.tencent.state.publicchat.action.AddToSquareAction;
import com.tencent.state.publicchat.action.MarkAllReadAction;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.action.ReportMsgAction;
import com.tencent.state.publicchat.action.ViewTaProfileAction;
import com.tencent.state.publicchat.activity.PublicChatViewModel;
import com.tencent.state.publicchat.data.LatestMsgInfos;
import com.tencent.state.publicchat.data.MsgHeader;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.MsgInfoChecked;
import com.tencent.state.publicchat.data.MsgInfos;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.publicchat.data.UserInfo;
import com.tencent.state.publicchat.fragment.ReportFragment;
import com.tencent.state.publicchat.service.SendMsgReq;
import com.tencent.state.publicchat.service.SendMsgRsp;
import com.tencent.state.publicchat.service.VasChatReadService;
import com.tencent.state.publicchat.service.VasChatWriteService;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.detail.DetailFragmentLauncher;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.SubScene;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import zr4.f;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0013\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\tH\u0016J$\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010-\u001a\u00020\u001eH\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016J\u0016\u00101\u001a\u00020\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030!H\u0002J\b\u00104\u001a\u00020\u001eH\u0016J\u0010\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020#H\u0016J\u001e\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u0002092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0;R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006="}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatMsgComponent;", "Lcom/tencent/state/publicchat/component/PublicChatBaseComponent;", "Lcom/tencent/state/publicchat/component/IPublicChatOwnerEventListener;", "owner", "Lcom/tencent/state/publicchat/IPublicChatOwner;", "(Lcom/tencent/state/publicchat/IPublicChatOwner;)V", "aioService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "getConf", "()Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "setConf", "(Lcom/tencent/state/publicchat/data/PublicChatConfInfo;)V", "lastSendMsgTs", "", "loader", "Lcom/tencent/state/publicchat/component/MsgSequenceLoader;", "pushListener", "com/tencent/state/publicchat/component/PublicChatMsgComponent$pushListener$1", "Lcom/tencent/state/publicchat/component/PublicChatMsgComponent$pushListener$1;", "vm", "Lcom/tencent/state/publicchat/activity/PublicChatViewModel;", "getVm", "()Lcom/tencent/state/publicchat/activity/PublicChatViewModel;", "setVm", "(Lcom/tencent/state/publicchat/activity/PublicChatViewModel;)V", "getMainScene", "Lcom/tencent/state/square/detail/MainScene;", "loadLatestMsgs", "", "loadNewMsgs", "ids", "", "needLocalTo", "", "onConfigLoaded", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "onLatestMsgsLoaded", "onMsgAction", "action", "Lcom/tencent/state/publicchat/action/MsgAction;", "onNewMsgLoaded", "msgs", "Lcom/tencent/state/publicchat/data/MsgInfo;", "onSceneExit", "onSceneReady", "forceReload", SmsPlugin.API_SEND_SMS, "msg", "Lcom/tencent/state/publicchat/service/SendMsgReq;", "onSuccess", "Lkotlin/Function0;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PublicChatMsgComponent extends PublicChatBaseComponent implements IPublicChatOwnerEventListener {
    private static final String TAG = "PublicChatMsgComponent";
    private ISquareBaseMessageService aioService;
    private PublicChatConfInfo conf;
    private long lastSendMsgTs;
    private final MsgSequenceLoader loader;
    private final IPublicChatOwner owner;
    private PublicChatMsgComponent$pushListener$1 pushListener;
    private PublicChatViewModel vm;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Scene.values().length];
            $EnumSwitchMapping$0 = iArr;
            Scene scene = Scene.SQUARE;
            iArr[scene.ordinal()] = 1;
            iArr[Scene.LIB.ordinal()] = 2;
            Scene scene2 = Scene.SQUARE_CHAT_BLOCK;
            iArr[scene2.ordinal()] = 3;
            Scene scene3 = Scene.SQUARE_CHAT_BLOCK_FIXED;
            iArr[scene3.ordinal()] = 4;
            Scene scene4 = Scene.SQUARE_RELAX_BLOCK_FIXED;
            iArr[scene4.ordinal()] = 5;
            Scene scene5 = Scene.SQUARE_CHAT_WUJI_BLOCK_1;
            iArr[scene5.ordinal()] = 6;
            Scene scene6 = Scene.SQUARE_CHAT_WUJI_BLOCK_2;
            iArr[scene6.ordinal()] = 7;
            int[] iArr2 = new int[Scene.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[scene.ordinal()] = 1;
            iArr2[scene2.ordinal()] = 2;
            iArr2[scene3.ordinal()] = 3;
            iArr2[scene4.ordinal()] = 4;
            iArr2[scene5.ordinal()] = 5;
            iArr2[scene6.ordinal()] = 6;
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.tencent.state.publicchat.component.PublicChatMsgComponent$pushListener$1] */
    public PublicChatMsgComponent(IPublicChatOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.loader = new MsgSequenceLoader(owner.getAppId(), new PublicChatMsgComponent$loader$1(this));
        this.pushListener = new ISquarePushListener() { // from class: com.tencent.state.publicchat.component.PublicChatMsgComponent$pushListener$1
            private final int appId;
            private final WeakReference<PublicChatMsgComponent> component;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPublicChatOwner iPublicChatOwner;
                this.component = new WeakReference<>(PublicChatMsgComponent.this);
                iPublicChatOwner = PublicChatMsgComponent.this.owner;
                this.appId = iPublicChatOwner.getAppId();
            }

            @Override // com.tencent.state.square.api.ISquarePushListener
            public void onResult(byte[] data) {
                List<Long> list;
                Intrinsics.checkNotNullParameter(data, "data");
                SquareBaseKt.getSquareLog().i("PublicChatMsgComponent", this.appId + " received message push");
                try {
                    list = new MsgInfos(f.c(data)).getMsgIds();
                } catch (Exception e16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "PublicChatMsgComponent", this.appId + " parsed received messages failed " + e16, null, 4, null);
                    list = null;
                }
                PublicChatMsgComponent publicChatMsgComponent = this.component.get();
                if (publicChatMsgComponent != null) {
                    publicChatMsgComponent.loadNewMsgs(list);
                }
            }
        };
    }

    private final MainScene getMainScene() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.owner.getScene().ordinal()]) {
            case 1:
                return MainScene.SQUARE;
            case 2:
                return MainScene.LIBRARY;
            case 3:
                return MainScene.SQUARE_CHAT_BLOCK;
            case 4:
                return MainScene.SQUARE_CHAT_BLOCK_FIXED;
            case 5:
                return MainScene.SQUARE_RELAX_BLOCK_FIXED;
            case 6:
                return MainScene.SQUARE_CHAT_WUJI_BLOCK_1;
            case 7:
                return MainScene.SQUARE_CHAT_WUJI_BLOCK_2;
            default:
                return MainScene.UNKNOWN;
        }
    }

    private final void loadLatestMsgs() {
        VasChatReadService.INSTANCE.listLatestMsgInfos(this.owner.getAppId(), this.owner.getRoomId(), new ResultCallback<LatestMsgInfos>() { // from class: com.tencent.state.publicchat.component.PublicChatMsgComponent$loadLatestMsgs$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                IPublicChatOwner iPublicChatOwner;
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                iPublicChatOwner = PublicChatMsgComponent.this.owner;
                sb5.append(iPublicChatOwner.getAppId());
                sb5.append(" failed to load latest msgs: ");
                sb5.append(error);
                sb5.append(TokenParser.SP);
                sb5.append(message);
                SquareLogger.DefaultImpls.e$default(squareLog, "PublicChatMsgComponent", sb5.toString(), null, 4, null);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(LatestMsgInfos result) {
                Intrinsics.checkNotNullParameter(result, "result");
                PublicChatViewModel vm5 = PublicChatMsgComponent.this.getVm();
                if (vm5 != null) {
                    vm5.setMsgs(result.getChannelId(), result.getMsgInfos());
                }
                PublicChatMsgComponent.this.onLatestMsgsLoaded();
            }
        });
    }

    private final boolean needLocalTo() {
        switch (WhenMappings.$EnumSwitchMapping$1[this.owner.getScene().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLatestMsgsLoaded() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ISquarePushService pushService;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(BasicServiceComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(BasicServiceComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, BasicServiceComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, BasicServiceComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        BasicServiceComponent basicServiceComponent = (BasicServiceComponent) fragmentComponent;
        if (basicServiceComponent == null || (pushService = basicServiceComponent.getPushService()) == null) {
            return;
        }
        pushService.addListener(9, this.pushListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNewMsgLoaded(List<MsgInfo> msgs) {
        SquareBaseKt.getSquareLog().i(TAG, this.owner.getAppId() + " onNewMsgLoaded " + msgs.size());
        PublicChatViewModel publicChatViewModel = this.vm;
        if (publicChatViewModel != null) {
            PublicChatConfInfo publicChatConfInfo = this.conf;
            publicChatViewModel.addMsgs(msgs, publicChatConfInfo != null ? publicChatConfInfo.getShowCount() : 10);
        }
    }

    public final PublicChatConfInfo getConf() {
        return this.conf;
    }

    public final PublicChatViewModel getVm() {
        return this.vm;
    }

    @Override // com.tencent.state.publicchat.component.PublicChatBaseComponent, com.tencent.state.publicchat.component.IPublicChatEventListener
    public void onConfigLoaded(PublicChatConfInfo conf) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        PublicChatViewModel vm5;
        Intrinsics.checkNotNullParameter(conf, "conf");
        this.conf = conf;
        if (conf.getShow()) {
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(PublicChatCommonComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(PublicChatCommonComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, PublicChatCommonComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, PublicChatCommonComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            PublicChatCommonComponent publicChatCommonComponent = (PublicChatCommonComponent) fragmentComponent;
            if (publicChatCommonComponent == null || (vm5 = publicChatCommonComponent.getVm()) == null) {
                return;
            }
            this.vm = vm5;
            loadLatestMsgs();
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        BasicServiceComponent basicServiceComponent;
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentCreated(fm5, f16, savedInstanceState);
        VasBaseFragment fragment = getFragment();
        this.aioService = (fragment == null || (basicServiceComponent = (BasicServiceComponent) VasBaseLifecycleFragment.getComponent$default(fragment, BasicServiceComponent.class, null, null, 6, null)) == null) ? null : basicServiceComponent.getMessageService();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        onSceneExit();
    }

    @Override // com.tencent.state.publicchat.component.PublicChatBaseComponent, com.tencent.state.publicchat.component.IPublicChatEventListener
    public void onMsgAction(final MsgAction action) {
        String str;
        Context context;
        LiveData<List<MsgInfo>> msgs;
        List<MsgInfo> list;
        VasBaseFragment fragment;
        PublicChatConfInfo publicChatConfInfo;
        List filterNotNull;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof MarkAllReadAction) {
            PublicChatViewModel publicChatViewModel = this.vm;
            if (publicChatViewModel != null) {
                publicChatViewModel.markAllRead();
                return;
            }
            return;
        }
        if (action instanceof ReportMsgAction) {
            PublicChatViewModel publicChatViewModel2 = this.vm;
            if (publicChatViewModel2 == null || (msgs = publicChatViewModel2.getMsgs()) == null || (list = msgs.getValue()) == null || (fragment = getFragment()) == null || (publicChatConfInfo = this.conf) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(list, "list");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
            ArrayList<MsgInfo> arrayList = new ArrayList();
            Iterator it = filterNotNull.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                MsgInfo msgInfo = (MsgInfo) next;
                if (!msgInfo.getSys() && msgInfo.getUser().getUin() == ((ReportMsgAction) action).getMsg().getUser().getUin()) {
                    arrayList.add(next);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (MsgInfo msgInfo2 : arrayList) {
                boolean z16 = msgInfo2.getHeader().getMsgId() == ((ReportMsgAction) action).getMsg().getHeader().getMsgId();
                arrayList2.add(new MsgInfoChecked(msgInfo2, z16, z16));
            }
            fragment.showFragment(new ReportFragment(publicChatConfInfo, arrayList2, this.owner.getAppId(), new Function0<Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatMsgComponent$onMsgAction$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    VasBaseFragment fragment2;
                    try {
                        fragment2 = PublicChatMsgComponent.this.getFragment();
                        if (fragment2 != null) {
                            fragment2.onResume();
                        }
                    } catch (Exception e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "PublicChatMsgComponent", "ReportFragment onBackCb onResume error " + e16, null, 4, null);
                    }
                }
            }));
            return;
        }
        if (action instanceof ViewTaProfileAction) {
            String valueOf = String.valueOf(((ViewTaProfileAction) action).getUser().getUin());
            ISquareBaseMessageService iSquareBaseMessageService = this.aioService;
            if (iSquareBaseMessageService != null && !iSquareBaseMessageService.isFriend(valueOf) && SquareBaseKt.getSquareCommon().getNeedShieldTeenager() && SquareBaseKt.getSquareCommon().getStudyMode()) {
                SquareBaseKt.getSquareLog().d(TAG, "click avatar bubble but is stranger and in study with teenager shield");
                return;
            }
            if (SquareRuntime.INSTANCE.hasNearbyMark()) {
                VasBaseFragment fragment2 = getFragment();
                if (fragment2 == null || (context = fragment2.getContext()) == null) {
                    return;
                }
                IRouter router = Square.INSTANCE.getConfig().getRouter();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                router.routeToNearbyDetailPage(context, valueOf);
                return;
            }
            DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
            VasBaseFragment fragment3 = getFragment();
            MainScene mainScene = getMainScene();
            SubScene subScene = SubScene.UNKNOWN;
            QBaseActivity activity = getActivity();
            if (activity == null || (str = SquareGroupReportComponentKt.getSourceFrom(activity)) == null) {
                str = "";
            }
            DetailFragmentLauncher.launch$default(detailFragmentLauncher, fragment3, new EntranceSource(mainScene, subScene, str), valueOf, null, null, 24, null);
            return;
        }
        if (action instanceof AddToSquareAction) {
            AddToSquareAction addToSquareAction = (AddToSquareAction) action;
            SimpleEventBus.getInstance().dispatchEvent(new ChatAddUinToSquare(addToSquareAction.getUin(), addToSquareAction.getRelationType(), getMainScene(), needLocalTo()));
        }
    }

    @Override // com.tencent.state.publicchat.component.IPublicChatOwnerEventListener
    public void onSceneExit() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ISquarePushService pushService;
        SquareBaseKt.getSquareLog().d(TAG, this.owner.getAppId() + " onSceneExit");
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(BasicServiceComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(BasicServiceComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, BasicServiceComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, BasicServiceComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        BasicServiceComponent basicServiceComponent = (BasicServiceComponent) fragmentComponent;
        if (basicServiceComponent == null || (pushService = basicServiceComponent.getPushService()) == null) {
            return;
        }
        pushService.removeListener(9, this.pushListener);
    }

    public final void sendMsg(final SendMsgReq msg2, final Function0<Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - this.lastSendMsgTs < (this.conf != null ? r2.getSendIntervalSecond() : 0)) {
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            VasBaseFragment fragment = getFragment();
            squareCommon.showToastSafely(fragment != null ? fragment.getContext() : null, "\u592a\u9891\u7e41\u5566\uff0c\u4f11\u606f\u4e00\u4f1a\u513f\u518d\u8bd5\u5427", 0);
            return;
        }
        this.lastSendMsgTs = currentTimeMillis;
        SquareBaseKt.getSquareLog().i(TAG, "send msg " + msg2);
        VasChatWriteService.INSTANCE.sendMsg(msg2, new ResultCallback<SendMsgRsp>() { // from class: com.tencent.state.publicchat.component.PublicChatMsgComponent$sendMsg$2
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message, String prompt) {
                VasBaseFragment fragment2;
                ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
                fragment2 = PublicChatMsgComponent.this.getFragment();
                squareCommon2.showToastSafely(fragment2 != null ? fragment2.getContext() : null, prompt, 0);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SendMsgRsp result) {
                List listOf;
                UserInfo user;
                String nick;
                Intrinsics.checkNotNullParameter(result, "result");
                SquareBaseKt.getSquareLog().i("PublicChatMsgComponent", "send msg success " + result);
                byte[] msgBody = MessageNano.toByteArray(msg2.getBody());
                PublicChatConfInfo conf = PublicChatMsgComponent.this.getConf();
                if (conf != null && (user = conf.getUser()) != null && (nick = user.getNick()) != null) {
                    if ((nick.length() > 0) && (!Intrinsics.areEqual(nick, result.getMsgInfo().getUser().getNick()))) {
                        result.getMsgInfo().getUser().setNick(nick);
                    }
                }
                UserInfo user2 = result.getMsgInfo().getUser();
                MsgHeader header = result.getMsgInfo().getHeader();
                Intrinsics.checkNotNullExpressionValue(msgBody, "msgBody");
                MsgInfo msgInfo = new MsgInfo(header, user2, msgBody, false);
                PublicChatMsgComponent publicChatMsgComponent = PublicChatMsgComponent.this;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(msgInfo);
                publicChatMsgComponent.onNewMsgLoaded(listOf);
                onSuccess.invoke();
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                IPublicChatOwner iPublicChatOwner;
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                iPublicChatOwner = PublicChatMsgComponent.this.owner;
                sb5.append(iPublicChatOwner.getAppId());
                sb5.append(" send msg failed ");
                sb5.append(error);
                sb5.append(TokenParser.SP);
                sb5.append(message);
                SquareLogger.DefaultImpls.e$default(squareLog, "PublicChatMsgComponent", sb5.toString(), null, 4, null);
                PublicChatMsgComponent.this.lastSendMsgTs = 0L;
            }
        });
    }

    public final void setConf(PublicChatConfInfo publicChatConfInfo) {
        this.conf = publicChatConfInfo;
    }

    public final void setVm(PublicChatViewModel publicChatViewModel) {
        this.vm = publicChatViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNewMsgs(List<Long> ids) {
        List<Long> list = ids;
        if (list == null || list.isEmpty()) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, this.owner.getAppId() + " parsed received messages " + ids);
        ArrayList arrayList = new ArrayList();
        for (Object obj : ids) {
            long longValue = ((Number) obj).longValue();
            PublicChatViewModel publicChatViewModel = this.vm;
            if ((publicChatViewModel == null || publicChatViewModel.msgExist(longValue)) ? false : true) {
                arrayList.add(obj);
            }
        }
        this.loader.load(arrayList, this.owner.getRoomId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendMsg$default(PublicChatMsgComponent publicChatMsgComponent, SendMsgReq sendMsgReq, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatMsgComponent$sendMsg$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        publicChatMsgComponent.sendMsg(sendMsgReq, function0);
    }

    @Override // com.tencent.state.publicchat.component.IPublicChatOwnerEventListener
    public void onSceneReady(boolean forceReload) {
    }
}
