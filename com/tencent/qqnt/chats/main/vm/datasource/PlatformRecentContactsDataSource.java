package com.tencent.qqnt.chats.main.vm.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.api.IMainChatEarManager;
import com.tencent.qqnt.chats.main.vm.datasource.e;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.AvatarSize;
import com.tencent.qqnt.kernel.nativeinterface.ContactTopData;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentJumpCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactJumpInfoVer2;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernel.utils.n;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0010\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001QB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000eJ\u001e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001d\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ0\u0010(\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010,\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010-\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010.\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ(\u00103\u001a\u00020\u00102\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u000101H\u0016J(\u00104\u001a\u00020\u00102\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u000101H\u0016J\b\u00105\u001a\u00020\u0010H\u0016J\b\u00106\u001a\u00020\u0010H\u0016J\b\u00107\u001a\u00020\u0010H\u0016J\u0006\u00108\u001a\u00020\u0010J&\u0010=\u001a\u00020\u00102\u0006\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u0018R\u0017\u0010\u0019\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010>\u001a\u0004\b?\u0010@R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010BR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00100D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010FR \u0010H\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00100D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010FR\u0016\u0010K\u001a\u0004\u0018\u00010\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAvatarListener;", "Lmqq/app/AppRuntime;", "i", "Lcom/tencent/qqnt/kernel/api/aa;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lcom/tencent/qqnt/kernel/api/w;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/api/m;", "j", "Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "listener", "", "d", "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/AnchorPointContactInfo;", "anchor", "loadNext", "t", "fetchOld", "", "listType", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", h.F, "", "chatUid", "", "chatUin", "isTop", "contactType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "g", "w", HippyTKDListViewAdapter.X, "e", "Ljava/util/HashMap;", "avatars", "Lcom/tencent/qqnt/kernel/nativeinterface/AvatarSize;", "size", "onAvatarChanged", "onGroupAvatarChanged", "onNtMsgSyncStart", "onNtFirstViewMsgSyncEnd", "onNtMsgSyncEnd", "f", "uid", "guildId", "chatType", "jumpType", "r", "I", "getListType", "()I", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "listenerRef", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "Lkotlin/jvm/functions/Function1;", "recentContactListener", "recentGuildContactListener", "l", "()Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "mListener", "k", "()Z", "hasListenRegistered", "<init>", "(I)V", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class PlatformRecentContactsDataSource implements IKernelMsgListener, IKernelAvatarListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int listType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<e> listenerRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<RecentContactListChangedInfo, Unit> recentContactListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<RecentContactListChangedInfo, Unit> recentGuildContactListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46093);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlatformRecentContactsDataSource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.listType = i3;
        this.recentContactListener = new Function1<RecentContactListChangedInfo, Unit>() { // from class: com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource$recentContactListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlatformRecentContactsDataSource.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
                invoke2(recentContactListChangedInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecentContactListChangedInfo it) {
                e l3;
                e l16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.listType == 6) {
                    l3 = PlatformRecentContactsDataSource.this.l();
                    if (l3 != null) {
                        l3.onLitterEarChange();
                    }
                    l16 = PlatformRecentContactsDataSource.this.l();
                    if (l16 == null) {
                        QLog.i("PlatformRecentContactsDataSource", 1, "listType=6 kernelWrapper == null");
                        return;
                    }
                    return;
                }
                n.f359273a.d(new Function0<Unit>(PlatformRecentContactsDataSource.this) { // from class: com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource$recentContactListener$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ PlatformRecentContactsDataSource this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = r5;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RecentContactListChangedInfo.this, (Object) r5);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        e l17;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        com.tencent.qqnt.chats.utils.e.f355546a.c(RecentContactListChangedInfo.this);
                        l17 = this.this$0.l();
                        if (l17 != null) {
                            RecentContactListChangedInfo recentContactListChangedInfo = RecentContactListChangedInfo.this;
                            int i16 = recentContactListChangedInfo.notificationType;
                            if (i16 == 1) {
                                e.a.f(l17, recentContactListChangedInfo, false, 2, null);
                                return;
                            }
                            if (i16 != 2) {
                                return;
                            }
                            ArrayList<Long> arrayList = recentContactListChangedInfo.sortedContactList;
                            Intrinsics.checkNotNullExpressionValue(arrayList, "it.sortedContactList");
                            ArrayList<RecentContactInfo> arrayList2 = recentContactListChangedInfo.changedList;
                            Intrinsics.checkNotNullExpressionValue(arrayList2, "it.changedList");
                            e.a.g(l17, arrayList, arrayList2, false, 4, null);
                        }
                    }
                });
            }
        };
        this.recentGuildContactListener = new Function1<RecentContactListChangedInfo, Unit>() { // from class: com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource$recentGuildContactListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlatformRecentContactsDataSource.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
                invoke2(recentContactListChangedInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecentContactListChangedInfo it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    n.f359273a.d(new Function0<Unit>(PlatformRecentContactsDataSource.this) { // from class: com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource$recentGuildContactListener$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ PlatformRecentContactsDataSource this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.this$0 = r5;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RecentContactListChangedInfo.this, (Object) r5);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            e l3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            com.tencent.qqnt.chats.utils.e.f355546a.c(RecentContactListChangedInfo.this);
                            l3 = this.this$0.l();
                            if (l3 != null) {
                                RecentContactListChangedInfo recentContactListChangedInfo = RecentContactListChangedInfo.this;
                                int i16 = recentContactListChangedInfo.notificationType;
                                if (i16 == 1) {
                                    l3.f(recentContactListChangedInfo, true);
                                    return;
                                }
                                if (i16 != 2) {
                                    return;
                                }
                                ArrayList<Long> arrayList = recentContactListChangedInfo.sortedContactList;
                                Intrinsics.checkNotNullExpressionValue(arrayList, "it.sortedContactList");
                                ArrayList<RecentContactInfo> arrayList2 = recentContactListChangedInfo.changedList;
                                Intrinsics.checkNotNullExpressionValue(arrayList2, "it.changedList");
                                l3.b(arrayList, arrayList2, true);
                            }
                        }
                    });
                }
            }
        };
    }

    private final AppRuntime i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
            return waitAppRuntime;
        }
        return peekAppRuntime;
    }

    private final m j() {
        m buddyService = ((IKernelService) i().getRuntimeService(IKernelService.class, "")).getBuddyService();
        if (buddyService == null) {
            QLog.i("PlatformRecentContactsDataSource", 1, "getBuddyService == null");
        }
        return buddyService;
    }

    private final boolean k() {
        if (l() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e l() {
        WeakReference<e> weakReference = this.listenerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final w m() {
        w msgService = ((IKernelService) i().getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.i("PlatformRecentContactsDataSource", 1, "getMsgService == null");
        }
        return msgService;
    }

    private final aa p() {
        aa recentContactService = ((IKernelService) i().getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.i("PlatformRecentContactsDataSource", 1, "getMsgService == null");
        }
        return recentContactService;
    }

    private final aa q() {
        AppRuntime i3 = i();
        IRuntimeService runtimeService = i3.getRuntimeService(IKernelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        IKernelService iKernelService = (IKernelService) runtimeService;
        aa recentContactService = iKernelService.getRecentContactService();
        if (recentContactService == null) {
            QLog.i("PlatformRecentContactsDataSource", 1, "appRuntime: " + i3.hashCode() + " kernelService: " + iKernelService.hashCode() + " getService == null");
        }
        return recentContactService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(WeakReference ref, int i3, String str, RecentContactInfo recentContactInfo) {
        e l3;
        Intrinsics.checkNotNullParameter(ref, "$ref");
        QLog.d("PlatformRecentContactsDataSource", 1, "jumpToItem: result=" + i3 + ", errMsg=" + str);
        PlatformRecentContactsDataSource platformRecentContactsDataSource = (PlatformRecentContactsDataSource) ref.get();
        if (platformRecentContactsDataSource != null && (l3 = platformRecentContactsDataSource.l()) != null) {
            l3.a(i3, str, recentContactInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(WeakReference ref, int i3, String msg2) {
        PlatformRecentContactsDataSource platformRecentContactsDataSource;
        e l3;
        Intrinsics.checkNotNullParameter(ref, "$ref");
        if (i3 != 0 && (platformRecentContactsDataSource = (PlatformRecentContactsDataSource) ref.get()) != null && (l3 = platformRecentContactsDataSource.l()) != null) {
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            l3.e(i3, msg2);
        }
    }

    public final void A(@NotNull String chatUid, long chatUin, boolean isTop, int contactType, @Nullable IOperateCallback callback) {
        boolean z16;
        ArrayList<ContactTopData> arrayListOf;
        ArrayList<ContactTopData> arrayListOf2;
        ArrayList<ContactTopData> arrayListOf3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, chatUid, Long.valueOf(chatUin), Boolean.valueOf(isTop), Integer.valueOf(contactType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        if (contactType != 1) {
            if (contactType != 2) {
                if (contactType != 8 && contactType != 30 && contactType != 103 && contactType != 118) {
                    Contact contact = new Contact(contactType, chatUid, "");
                    w m3 = m();
                    if (m3 != null) {
                        m3.setContactLocalTop(contact, isTop, callback);
                        return;
                    }
                    return;
                }
                ContactTopData contactTopData = new ContactTopData();
                contactTopData.chatType = contactType;
                contactTopData.uin = chatUin;
                contactTopData.uid = chatUid;
                aa p16 = p();
                if (p16 != null) {
                    arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(contactTopData);
                    p16.setContactListTop(isTop, arrayListOf3, callback);
                    return;
                }
                return;
            }
            long parseLong = Long.parseLong(chatUid);
            ContactTopData contactTopData2 = new ContactTopData();
            contactTopData2.chatType = 2;
            contactTopData2.groupCode = parseLong;
            aa p17 = p();
            if (p17 != null) {
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(contactTopData2);
                p17.setContactListTop(isTop, arrayListOf2, callback);
                return;
            }
            return;
        }
        m j3 = j();
        if (j3 != null) {
            z16 = Intrinsics.areEqual(j3.isBuddy(chatUid), Boolean.TRUE);
        } else {
            z16 = false;
        }
        if (z16) {
            ContactTopData contactTopData3 = new ContactTopData();
            contactTopData3.chatType = 1;
            contactTopData3.uin = chatUin;
            contactTopData3.uid = chatUid;
            aa p18 = p();
            if (p18 != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(contactTopData3);
                p18.setContactListTop(isTop, arrayListOf, callback);
                return;
            }
            return;
        }
        w m16 = m();
        if (m16 != null) {
            m16.setContactLocalTop(new Contact(contactType, chatUid, ""), isTop, callback);
        }
    }

    public final boolean d(@NotNull e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (k()) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("PlatformRecentContactsDataSource", 1, "[addListener] this=" + hashCode());
        }
        aa q16 = q();
        if (q16 == null) {
            return false;
        }
        q16.g0(this.listType, this.recentContactListener);
        if (this.listType == 1) {
            q16.s0(10, this.recentGuildContactListener);
            q16.g0(6, this.recentContactListener);
            ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).fetchEarChatList();
        }
        w m3 = m();
        if (m3 != null) {
            m3.addMsgListener(this);
        }
        this.listenerRef = new WeakReference<>(listener);
        return true;
    }

    public final void e(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) peer, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        aa q16 = q();
        if (q16 != null) {
            q16.addRecentContact(peer, callback);
        }
    }

    public final void f() {
        aa q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else if (this.listType != 1 && (q16 = q()) != null) {
            q16.c0(Integer.valueOf(this.listType));
        }
    }

    public final void g(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) peer, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w m3 = m();
        if (m3 != null) {
            m3.setMsgRead(peer, callback);
        }
    }

    public final void h(@NotNull RecentContactInfo contact, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) contact, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        ArrayList<Contact> arrayList = new ArrayList<>();
        arrayList.add(new Contact(contact.chatType, contact.peerUid, ex3.a.f(contact)));
        aa q16 = q();
        if (q16 != null) {
            q16.a0(arrayList, callback);
        }
    }

    public final boolean n() {
        final RecentContactListChangedInfo i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        QLog.i("PlatformRecentContactsDataSource", 1, "getRecentContactFromCache: listType=" + this.listType);
        aa q16 = q();
        if (q16 == null || (i3 = q16.i(this.listType)) == null) {
            return false;
        }
        QLog.i("PlatformRecentContactsDataSource", 1, "getRecentContactFromCache contactSize=" + i3.changedList.size() + ",sortSize=" + i3.sortedContactList.size());
        int i16 = i3.notificationType;
        if (i16 == 2) {
            QLog.i("PlatformRecentContactsDataSource", 1, "getRecentContactFromCache type is =" + i16);
            return false;
        }
        if (i3.changedList.isEmpty()) {
            return false;
        }
        n.f359273a.d(new Function0<Unit>(i3) { // from class: com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource$getRecentContactFromCache$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ RecentContactListChangedInfo $it;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$it = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlatformRecentContactsDataSource.this, (Object) i3);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                e l3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                l3 = PlatformRecentContactsDataSource.this.l();
                if (l3 != null) {
                    e.a.f(l3, this.$it, false, 2, null);
                }
            }
        });
        return true;
    }

    public final void o(@Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
            return;
        }
        QLog.i("PlatformRecentContactsDataSource", 1, "getRecentContactList: listType=" + this.listType);
        t(new AnchorPointContactInfo(), true);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
        ax.a(this, msgRecord);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        r4 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r4);
     */
    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAvatarChanged(@Nullable HashMap<String, String> avatars, @Nullable AvatarSize size) {
        List<String> list;
        e l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) avatars, (Object) size);
        } else if (avatars != null && (r4 = avatars.keySet()) != null && list != null && (l3 = l()) != null) {
            l3.d(list);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarListener
    public /* synthetic */ void onAvatarChangedForUin(HashMap hashMap, AvatarSize avatarSize) {
        com.tencent.qqnt.kernel.nativeinterface.w.b(this, hashMap, avatarSize);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
        ax.b(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
        ax.c(this, customWithdrawConfig);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
        ax.d(this, contact, arrayList, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
        ax.e(this, emojiNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
        ax.f(this, emojiResourceInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
        ax.g(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
        ax.h(this, i3, str, i16, recvdOrder, msgRecord);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        r4 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r4);
     */
    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGroupAvatarChanged(@Nullable HashMap<Long, String> avatars, @Nullable AvatarSize size) {
        List<Long> list;
        e l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) avatars, (Object) size);
        } else if (avatars != null && (r4 = avatars.keySet()) != null && list != null && (l3 = l()) != null) {
            l3.c(list);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
        ax.i(this, groupItem);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
        ax.j(this, groupFileListResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarListener
    public /* synthetic */ void onGroupPortraitChanged(long j3, HashMap hashMap, AvatarSize avatarSize) {
        com.tencent.qqnt.kernel.nativeinterface.w.d(this, j3, hashMap, avatarSize);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
        ax.k(this, groupItem);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
        ax.l(this, groupFileListResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
        ax.m(this, downloadRelateEmojiResultInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
        ax.n(this, hitRelatedEmojiWordsResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
        ax.o(this, relatedWordEmojiInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
        ax.p(this, importOldDbMsgNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
        ax.q(this, inputStatusInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
        ax.r(this, kickedInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onLineDev(ArrayList arrayList) {
        ax.s(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onLogLevelChanged(long j3) {
        ax.t(this, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
        ax.u(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
        ax.v(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
        ax.w(this, contact, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
        ax.x(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
        ax.y(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
        ax.z(this, i3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
        ax.A(this, i3, str, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
        ax.B(this, msgRecord);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
        ax.C(this, msgSetting);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
        ax.D(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onNtFirstViewMsgSyncEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            QLog.i("PlatformRecentContactsDataSource", 1, "onNtFirstViewMsgSyncEnd");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onNtMsgSyncContactUnread() {
        ax.F(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onNtMsgSyncEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            QLog.i("PlatformRecentContactsDataSource", 1, "onNtMsgSyncEnd");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public void onNtMsgSyncStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            QLog.i("PlatformRecentContactsDataSource", 1, "onNtMsgSyncStart");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
        ax.I(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
        ax.J(this, j3, contact, i3, i16, str, bArr);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
        ax.K(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
        ax.L(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRedTouchChanged() {
        ax.M(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
        ax.N(this, fileTransNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
        ax.O(this, fileTransNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
        ax.P(this, fileTransNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
        ax.Q(this, searchGroupFileResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
        ax.R(this, j3, contact, i3, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
        ax.S(this, i3, j3, j16, z16, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
        ax.T(this, tempChatInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
        ax.U(this, z16);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
        ax.V(this, z16);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
        ax.W(this, queryUserSecQualityRsp);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
        ax.X(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
        ax.Y(this, i3, j3, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
        ax.Z(this, i3, j3, str);
    }

    public final void r(@NotNull String uid, @NotNull String guildId, int chatType, int jumpType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, uid, guildId, Integer.valueOf(chatType), Integer.valueOf(jumpType));
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        final WeakReference weakReference = new WeakReference(this);
        aa q16 = q();
        if (q16 != null) {
            q16.jumpToSpecifyRecentContactVer2(new RecentContactJumpInfoVer2(uid, guildId, chatType, jumpType, false), new IKernelRecentJumpCallback() { // from class: com.tencent.qqnt.chats.main.vm.datasource.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentJumpCallback
                public final void onResult(int i3, String str, RecentContactInfo recentContactInfo) {
                    PlatformRecentContactsDataSource.s(weakReference, i3, str, recentContactInfo);
                }
            });
        }
    }

    public final void t(@NotNull AnchorPointContactInfo anchor, boolean loadNext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, anchor, Boolean.valueOf(loadNext));
            return;
        }
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        QLog.i("PlatformRecentContactsDataSource", 1, "[loadRecentContact] anchor=" + anchor.pos + "-" + anchor.contactId + ", loadNext=" + loadNext);
        aa q16 = q();
        if (q16 == null) {
            e l3 = l();
            if (l3 != null) {
                l3.e(-1, "[local] get service fail");
                return;
            }
            return;
        }
        final WeakReference weakReference = new WeakReference(this);
        aa.b.a(q16, anchor, loadNext, this.listType, 0, new IOperateCallback() { // from class: com.tencent.qqnt.chats.main.vm.datasource.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                PlatformRecentContactsDataSource.u(weakReference, i3, str);
            }
        }, 8, null);
    }

    public final void v(@NotNull AnchorPointContactInfo anchor, boolean fetchOld, int listType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, anchor, Boolean.valueOf(fetchOld), Integer.valueOf(listType));
            return;
        }
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        aa q16 = q();
        if (q16 != null) {
            aa.b.a(q16, anchor, fetchOld, listType, 0, null, 24, null);
        }
    }

    public final void w(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) peer, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w m3 = m();
        if (m3 != null) {
            m3.setMsgRead(peer, callback);
        }
    }

    public final void x(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) peer, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        w m3 = m();
        if (m3 != null) {
            m3.setMarkUnreadFlag(peer, true);
        }
    }

    public final void y(@NotNull e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (QLog.isDevelopLevel()) {
            QLog.i("PlatformRecentContactsDataSource", 1, "[removeListener] this=" + hashCode() + " stack=" + QLog.getStackTraceString(new RuntimeException()));
        }
        aa q16 = q();
        if (q16 != null) {
            q16.m(this.listType, this.recentContactListener);
        }
        if (this.listType == 1) {
            aa q17 = q();
            if (q17 != null) {
                q17.u0(10, this.recentGuildContactListener);
            }
            aa q18 = q();
            if (q18 != null) {
                q18.m(6, this.recentContactListener);
            }
        }
        w m3 = m();
        if (m3 != null) {
            m3.removeMsgListener(this);
        }
        this.listenerRef = null;
        f();
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
