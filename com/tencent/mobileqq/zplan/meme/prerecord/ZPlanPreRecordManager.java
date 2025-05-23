package com.tencent.mobileqq.zplan.meme.prerecord;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vas.data.SquareRecordReason;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager;
import com.tencent.mobileqq.zplan.avatar.image.l;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager;
import com.tencent.mobileqq.zplan.meme.prerecord.birthdaycare.ZPlanBirthdayCareRecordHelper;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl;
import com.tencent.mobileqq.zplan.servlet.m;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.ZPlanSharePreRecordUtil;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.state.data.SquareJSConst;
import com.tencent.zplan.common.utils.i;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.manager.Manager;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J)\u0010\u000e\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J)\u0010\u0015\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u000fJ\u0010\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001b\u001a\u00020\u0007J\u001e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0014\u0010\u001e\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0018\u0010!\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010)R\u0014\u0010-\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/prerecord/ZPlanPreRecordManager;", "Lcom/tencent/mobileqq/zplan/servlet/m;", "Lcom/tencent/mobileqq/zootopia/Source;", "portalSource", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "e", "(Lcom/tencent/mobileqq/zootopia/Source;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changedUinList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/zplan/meme/Priority;", "priority", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/util/List;Lcom/tencent/zplan/meme/Priority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "j", "l", "", "d", "i", "Lcom/tencent/mobileqq/zplan/meme/prerecord/ZPlanPreRecordManager$a;", "listener", DomainData.DOMAIN_NAME, "Lji3/h;", "o", h.F, "success", "a", "k", "f", "Lcom/tencent/mobileqq/zplan/meme/prerecord/ZPlanPreRecordManager$a;", "recordAvatarActionListener", "Lji3/h;", "shareRecordListener", "Lcom/tencent/mobileqq/zplan/avatar/image/l;", "Lkotlin/Lazy;", "getStaticImageRecorder", "()Lcom/tencent/mobileqq/zplan/avatar/image/l;", "staticImageRecorder", "()Lcom/tencent/mobileqq/zootopia/Source;", "currentPortalRefer", "g", "()Ljava/lang/String;", "currentPortalSubSource", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPreRecordManager extends m {

    /* renamed from: e, reason: collision with root package name */
    public static final ZPlanPreRecordManager f334206e = new ZPlanPreRecordManager();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static a recordAvatarActionListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static ji3.h shareRecordListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final Lazy staticImageRecorder;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/prerecord/ZPlanPreRecordManager$a;", "", "Lcom/tencent/zplan/meme/Priority;", "priority", "", "J6", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void J6(Priority priority);
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f334210a;

        static {
            int[] iArr = new int[Source.values().length];
            try {
                iArr[Source.AvatarEdit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Source.DynamicEntry.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Source.ProfileEntry.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Source.Emoticon.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Source.Conversation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f334210a = iArr;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager$staticImageRecorder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final l invoke() {
                return new l();
            }
        });
        staticImageRecorder = lazy;
    }

    ZPlanPreRecordManager() {
    }

    private final boolean d(List<String> changedUinList) {
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            return false;
        }
        return changedUinList.contains(c16.getCurrentUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0138 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x020b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x023d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(Source source, List<String> list, Continuation<? super Unit> continuation) {
        ZPlanPreRecordManager$doPreRecordByPortalSource$1 zPlanPreRecordManager$doPreRecordByPortalSource$1;
        Object coroutine_suspended;
        List<String> list2;
        ZPlanPreRecordManager zPlanPreRecordManager;
        List<String> list3;
        ZPlanPreRecordManager zPlanPreRecordManager2;
        List<String> list4;
        ZPlanPreRecordManager zPlanPreRecordManager3;
        List<String> list5;
        ZPlanPreRecordManager zPlanPreRecordManager4;
        List<String> list6;
        ZPlanPreRecordManager zPlanPreRecordManager5;
        List<String> list7;
        ZPlanPreRecordManager zPlanPreRecordManager6;
        Priority priority;
        Priority priority2;
        Priority priority3;
        Priority priority4;
        Priority priority5;
        Priority priority6;
        if (continuation instanceof ZPlanPreRecordManager$doPreRecordByPortalSource$1) {
            zPlanPreRecordManager$doPreRecordByPortalSource$1 = (ZPlanPreRecordManager$doPreRecordByPortalSource$1) continuation;
            int i3 = zPlanPreRecordManager$doPreRecordByPortalSource$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                zPlanPreRecordManager$doPreRecordByPortalSource$1.label = i3 - Integer.MIN_VALUE;
                Object obj = zPlanPreRecordManager$doPreRecordByPortalSource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (zPlanPreRecordManager$doPreRecordByPortalSource$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        int i16 = b.f334210a[source.ordinal()];
                        if (i16 == 1) {
                            Priority priority7 = Priority.HIGH;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = this;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 1;
                            if (m(list, priority7, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            list2 = list;
                            zPlanPreRecordManager = this;
                            Priority priority8 = Priority.HIGH;
                            zPlanPreRecordManager.p(list2, priority8);
                            zPlanPreRecordManager.j(list2, priority8);
                            zPlanPreRecordManager.l(list2);
                            zPlanPreRecordManager.k(list2);
                            priority = Priority.MIDDLE;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list2;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 2;
                            if (zPlanPreRecordManager.i(list2, priority, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            zPlanPreRecordManager.q(list2);
                            return Unit.INSTANCE;
                        }
                        if (i16 == 2 || i16 == 3) {
                            Priority priority9 = Priority.HIGH;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = this;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 3;
                            if (m(list, priority9, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            list3 = list;
                            zPlanPreRecordManager2 = this;
                            zPlanPreRecordManager2.p(list3, Priority.HIGH);
                            priority2 = Priority.MIDDLE;
                            zPlanPreRecordManager2.j(list3, priority2);
                            zPlanPreRecordManager2.l(list3);
                            zPlanPreRecordManager2.k(list3);
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager2;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list3;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 4;
                            if (zPlanPreRecordManager2.i(list3, priority2, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            zPlanPreRecordManager2.q(list3);
                            return Unit.INSTANCE;
                        }
                        if (i16 == 4) {
                            Priority priority10 = Priority.HIGH;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = this;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 5;
                            if (m(list, priority10, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            list4 = list;
                            zPlanPreRecordManager3 = this;
                            zPlanPreRecordManager3.p(list4, Priority.HIGH);
                            zPlanPreRecordManager3.l(list4);
                            zPlanPreRecordManager3.k(list4);
                            priority3 = Priority.MIDDLE;
                            zPlanPreRecordManager3.j(list4, priority3);
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager3;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list4;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 6;
                            if (zPlanPreRecordManager3.i(list4, priority3, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            zPlanPreRecordManager3.q(list4);
                            return Unit.INSTANCE;
                        }
                        if (i16 != 5) {
                            if (Intrinsics.areEqual(g(), ZootopiaSource.SUB_SOURCE_PK_PORTAL)) {
                                Priority priority11 = Priority.HIGH;
                                zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = this;
                                zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list;
                                zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 9;
                                if (m(list, priority11, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                list7 = list;
                                zPlanPreRecordManager6 = this;
                                zPlanPreRecordManager6.p(list7, Priority.HIGH);
                                zPlanPreRecordManager6.l(list7);
                                zPlanPreRecordManager6.k(list7);
                                priority5 = Priority.MIDDLE;
                                zPlanPreRecordManager6.j(list7, priority5);
                                zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager6;
                                zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list7;
                                zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 10;
                                if (zPlanPreRecordManager6.i(list7, priority5, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                zPlanPreRecordManager6.q(list7);
                                return Unit.INSTANCE;
                            }
                            Priority priority12 = Priority.HIGH;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = this;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 11;
                            if (m(list, priority12, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            list6 = list;
                            zPlanPreRecordManager5 = this;
                            zPlanPreRecordManager5.p(list6, Priority.HIGH);
                            zPlanPreRecordManager5.l(list6);
                            zPlanPreRecordManager5.k(list6);
                            priority6 = Priority.MIDDLE;
                            zPlanPreRecordManager5.j(list6, priority6);
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager5;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list6;
                            zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 12;
                            if (zPlanPreRecordManager5.i(list6, priority6, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            zPlanPreRecordManager5.q(list6);
                            return Unit.INSTANCE;
                        }
                        Priority priority13 = Priority.HIGH;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = this;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 7;
                        if (m(list, priority13, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list5 = list;
                        zPlanPreRecordManager4 = this;
                        zPlanPreRecordManager4.p(list5, Priority.HIGH);
                        zPlanPreRecordManager4.l(list5);
                        zPlanPreRecordManager4.k(list5);
                        priority4 = Priority.MIDDLE;
                        zPlanPreRecordManager4.j(list5, priority4);
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager4;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list5;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 8;
                        if (zPlanPreRecordManager4.i(list5, priority4, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanPreRecordManager4.q(list5);
                        return Unit.INSTANCE;
                    case 1:
                        List<String> list8 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        ZPlanPreRecordManager zPlanPreRecordManager7 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager = zPlanPreRecordManager7;
                        list2 = list8;
                        Priority priority82 = Priority.HIGH;
                        zPlanPreRecordManager.p(list2, priority82);
                        zPlanPreRecordManager.j(list2, priority82);
                        zPlanPreRecordManager.l(list2);
                        zPlanPreRecordManager.k(list2);
                        priority = Priority.MIDDLE;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list2;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 2;
                        if (zPlanPreRecordManager.i(list2, priority, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                        }
                        zPlanPreRecordManager.q(list2);
                        return Unit.INSTANCE;
                    case 2:
                        list2 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        zPlanPreRecordManager = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager.q(list2);
                        return Unit.INSTANCE;
                    case 3:
                        List<String> list9 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        ZPlanPreRecordManager zPlanPreRecordManager8 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager2 = zPlanPreRecordManager8;
                        list3 = list9;
                        zPlanPreRecordManager2.p(list3, Priority.HIGH);
                        priority2 = Priority.MIDDLE;
                        zPlanPreRecordManager2.j(list3, priority2);
                        zPlanPreRecordManager2.l(list3);
                        zPlanPreRecordManager2.k(list3);
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager2;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list3;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 4;
                        if (zPlanPreRecordManager2.i(list3, priority2, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                        }
                        zPlanPreRecordManager2.q(list3);
                        return Unit.INSTANCE;
                    case 4:
                        list3 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        zPlanPreRecordManager2 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager2.q(list3);
                        return Unit.INSTANCE;
                    case 5:
                        List<String> list10 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        ZPlanPreRecordManager zPlanPreRecordManager9 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager3 = zPlanPreRecordManager9;
                        list4 = list10;
                        zPlanPreRecordManager3.p(list4, Priority.HIGH);
                        zPlanPreRecordManager3.l(list4);
                        zPlanPreRecordManager3.k(list4);
                        priority3 = Priority.MIDDLE;
                        zPlanPreRecordManager3.j(list4, priority3);
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager3;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list4;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 6;
                        if (zPlanPreRecordManager3.i(list4, priority3, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                        }
                        zPlanPreRecordManager3.q(list4);
                        return Unit.INSTANCE;
                    case 6:
                        list4 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        zPlanPreRecordManager3 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager3.q(list4);
                        return Unit.INSTANCE;
                    case 7:
                        List<String> list11 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        ZPlanPreRecordManager zPlanPreRecordManager10 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager4 = zPlanPreRecordManager10;
                        list5 = list11;
                        zPlanPreRecordManager4.p(list5, Priority.HIGH);
                        zPlanPreRecordManager4.l(list5);
                        zPlanPreRecordManager4.k(list5);
                        priority4 = Priority.MIDDLE;
                        zPlanPreRecordManager4.j(list5, priority4);
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager4;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list5;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 8;
                        if (zPlanPreRecordManager4.i(list5, priority4, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                        }
                        zPlanPreRecordManager4.q(list5);
                        return Unit.INSTANCE;
                    case 8:
                        list5 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        zPlanPreRecordManager4 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager4.q(list5);
                        return Unit.INSTANCE;
                    case 9:
                        List<String> list12 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        ZPlanPreRecordManager zPlanPreRecordManager11 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager6 = zPlanPreRecordManager11;
                        list7 = list12;
                        zPlanPreRecordManager6.p(list7, Priority.HIGH);
                        zPlanPreRecordManager6.l(list7);
                        zPlanPreRecordManager6.k(list7);
                        priority5 = Priority.MIDDLE;
                        zPlanPreRecordManager6.j(list7, priority5);
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager6;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list7;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 10;
                        if (zPlanPreRecordManager6.i(list7, priority5, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                        }
                        zPlanPreRecordManager6.q(list7);
                        return Unit.INSTANCE;
                    case 10:
                        list7 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        zPlanPreRecordManager6 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager6.q(list7);
                        return Unit.INSTANCE;
                    case 11:
                        List<String> list13 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        ZPlanPreRecordManager zPlanPreRecordManager12 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager5 = zPlanPreRecordManager12;
                        list6 = list13;
                        zPlanPreRecordManager5.p(list6, Priority.HIGH);
                        zPlanPreRecordManager5.l(list6);
                        zPlanPreRecordManager5.k(list6);
                        priority6 = Priority.MIDDLE;
                        zPlanPreRecordManager5.j(list6, priority6);
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0 = zPlanPreRecordManager5;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1 = list6;
                        zPlanPreRecordManager$doPreRecordByPortalSource$1.label = 12;
                        if (zPlanPreRecordManager5.i(list6, priority6, zPlanPreRecordManager$doPreRecordByPortalSource$1) == coroutine_suspended) {
                        }
                        zPlanPreRecordManager5.q(list6);
                        return Unit.INSTANCE;
                    case 12:
                        list6 = (List) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$1;
                        zPlanPreRecordManager5 = (ZPlanPreRecordManager) zPlanPreRecordManager$doPreRecordByPortalSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        zPlanPreRecordManager5.q(list6);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        zPlanPreRecordManager$doPreRecordByPortalSource$1 = new ZPlanPreRecordManager$doPreRecordByPortalSource$1(this, continuation);
        Object obj2 = zPlanPreRecordManager$doPreRecordByPortalSource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (zPlanPreRecordManager$doPreRecordByPortalSource$1.label) {
        }
    }

    private final Source f() {
        Source mainSource;
        ag agVar = ag.f373258a;
        ZootopiaSource c16 = agVar.c(agVar.b());
        return (c16 == null || (mainSource = c16.getMainSource()) == null) ? Source.UnSet : mainSource;
    }

    private final String g() {
        String subSource;
        ag agVar = ag.f373258a;
        ZootopiaSource c16 = agVar.c(agVar.b());
        return (c16 == null || (subSource = c16.getSubSource()) == null) ? "" : subSource;
    }

    private final Object i(List<String> list, Priority priority, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (!d(list)) {
            QLog.w("ZPlanPreRecordManager", 1, "preRecordBirthdayCareAvatar failed, currentUserDressChanged false.");
            return Unit.INSTANCE;
        }
        QLog.i("ZPlanPreRecordManager", 1, "preRecordBirthdayCareAvatar priority:" + priority);
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            return Unit.INSTANCE;
        }
        ZPlanBirthdayCareRecordHelper zPlanBirthdayCareRecordHelper = ZPlanBirthdayCareRecordHelper.f334211a;
        String currentUin = c16.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
        Object b16 = zPlanBirthdayCareRecordHelper.b(currentUin, priority, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return b16 == coroutine_suspended ? b16 : Unit.INSTANCE;
    }

    private final void j(List<String> changedUinList, Priority priority) {
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null && d(changedUinList)) {
            QLog.i("ZPlanPreRecordManager", 1, "preRecordEditAvatarActions priority:" + priority);
            Manager manager = c16.getManager(QQManagerFactory.ZPLAN_EDIT_AVATAR_MANAGER);
            ZPlanEditAvatarManager zPlanEditAvatarManager = manager instanceof ZPlanEditAvatarManager ? (ZPlanEditAvatarManager) manager : null;
            a aVar = recordAvatarActionListener;
            if (aVar != null) {
                Intrinsics.checkNotNull(aVar);
                aVar.J6(priority);
            } else if (zPlanEditAvatarManager != null) {
                zPlanEditAvatarManager.r0(priority, 1);
            }
        }
    }

    private final void l(List<String> changedUinList) {
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null && d(changedUinList)) {
            boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, c16.getLongAccountUin());
            ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
            boolean S = zPlanFeatureSwitch.S();
            boolean v3 = zPlanFeatureSwitch.v();
            QLog.i("ZPlanPreRecordManager", 1, "preRecordEmoticonAvatarIcon, enableEmoticonScene:" + isZPlanAccessible + ", recordOnAppearanceChange:" + S + " enableEmoticonAvatarIcon:" + v3);
            if (isZPlanAccessible && S && v3) {
                ZPlanEmoticonTabAvatarManager.f333345a.G();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(List<String> list, Priority priority, Continuation<? super Unit> continuation) {
        ZPlanPreRecordManager$preRecordShareActions$1 zPlanPreRecordManager$preRecordShareActions$1;
        Object coroutine_suspended;
        int i3;
        Priority priority2;
        AppInterface appInterface;
        dw4.b bVar;
        gx4.a aVar;
        AvatarCharacterInfo avatarCharacterInfo;
        if (continuation instanceof ZPlanPreRecordManager$preRecordShareActions$1) {
            zPlanPreRecordManager$preRecordShareActions$1 = (ZPlanPreRecordManager$preRecordShareActions$1) continuation;
            int i16 = zPlanPreRecordManager$preRecordShareActions$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanPreRecordManager$preRecordShareActions$1.label = i16 - Integer.MIN_VALUE;
                ZPlanPreRecordManager$preRecordShareActions$1 zPlanPreRecordManager$preRecordShareActions$12 = zPlanPreRecordManager$preRecordShareActions$1;
                Object obj = zPlanPreRecordManager$preRecordShareActions$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanPreRecordManager$preRecordShareActions$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AppInterface c16 = bb.f335811a.c();
                    if (c16 == null) {
                        return Unit.INSTANCE;
                    }
                    if (!d(list)) {
                        return Unit.INSTANCE;
                    }
                    QLog.i("ZPlanPreRecordManager", 1, "preRecordShareActions priority:" + priority);
                    ji3.h hVar = shareRecordListener;
                    if (hVar == null) {
                        ZPlanAvatarInfoHelperImpl.Companion companion = ZPlanAvatarInfoHelperImpl.INSTANCE;
                        zPlanPreRecordManager$preRecordShareActions$12.L$0 = priority;
                        zPlanPreRecordManager$preRecordShareActions$12.L$1 = c16;
                        zPlanPreRecordManager$preRecordShareActions$12.label = 1;
                        Object dressInfo = companion.getDressInfo(zPlanPreRecordManager$preRecordShareActions$12);
                        if (dressInfo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        priority2 = priority;
                        obj = dressInfo;
                        appInterface = c16;
                        bVar = (dw4.b) obj;
                        if (bVar != null) {
                        }
                    } else {
                        if (hVar != null) {
                            zPlanPreRecordManager$preRecordShareActions$12.label = 3;
                            if (hVar.c(zPlanPreRecordManager$preRecordShareActions$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } else if (i3 == 1) {
                    appInterface = (AppInterface) zPlanPreRecordManager$preRecordShareActions$12.L$1;
                    Priority priority3 = (Priority) zPlanPreRecordManager$preRecordShareActions$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    priority2 = priority3;
                    bVar = (dw4.b) obj;
                    if (bVar != null) {
                        return Unit.INSTANCE;
                    }
                    String dressKey = bVar.f395115b.f429598b;
                    qu4.a avatarCharacterByGender = ZPlanAvatarInfoHelperImpl.INSTANCE.avatarCharacterByGender(bVar);
                    if (avatarCharacterByGender == null) {
                        return Unit.INSTANCE;
                    }
                    try {
                        aVar = gx4.a.c(MessageNano.toByteArray(avatarCharacterByGender));
                    } catch (Exception unused) {
                        QLog.e("ZPlanPreRecordManager", 1, "convert AvatarCharacter error");
                        aVar = null;
                    }
                    if (aVar == null) {
                        avatarCharacterInfo = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(dressKey, "dressKey");
                        avatarCharacterInfo = new AvatarCharacterInfo(aVar, dressKey);
                    }
                    ZPlanSharePreRecordUtil zPlanSharePreRecordUtil = ZPlanSharePreRecordUtil.f371750a;
                    String currentUin = appInterface.getCurrentUin();
                    Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
                    zPlanPreRecordManager$preRecordShareActions$12.L$0 = null;
                    zPlanPreRecordManager$preRecordShareActions$12.L$1 = null;
                    zPlanPreRecordManager$preRecordShareActions$12.label = 2;
                    if (ZPlanSharePreRecordUtil.g(zPlanSharePreRecordUtil, currentUin, priority2, avatarCharacterInfo, null, zPlanPreRecordManager$preRecordShareActions$12, 8, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        zPlanPreRecordManager$preRecordShareActions$1 = new ZPlanPreRecordManager$preRecordShareActions$1(this, continuation);
        ZPlanPreRecordManager$preRecordShareActions$1 zPlanPreRecordManager$preRecordShareActions$122 = zPlanPreRecordManager$preRecordShareActions$1;
        Object obj2 = zPlanPreRecordManager$preRecordShareActions$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanPreRecordManager$preRecordShareActions$122.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }

    private final void p(List<String> changedUinList, Priority priority) {
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null && d(changedUinList)) {
            QLog.i("ZPlanPreRecordManager", 1, "updateAvatarAccordingToDress priority:" + priority);
            Manager manager = c16.getManager(QQManagerFactory.ZPLAN_EDIT_AVATAR_MANAGER);
            ZPlanEditAvatarManager zPlanEditAvatarManager = manager instanceof ZPlanEditAvatarManager ? (ZPlanEditAvatarManager) manager : null;
            if (zPlanEditAvatarManager != null) {
                zPlanEditAvatarManager.K0(priority);
            }
        }
    }

    private final void q(List<String> changedUinList) {
        AppInterface c16;
        if (d(changedUinList) && (c16 = bb.f335811a.c()) != null) {
            ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
            String currentUin = c16.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            ZPlanUserInfo l3 = ZplanDataRepository.l(zplanDataRepository, currentUin, false, 2, null);
            if (l3 != null) {
                ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).refreshAppearance(l3.appearanceKey, l3.gender);
                ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).recordFilamentAvatarCover(SquareRecordReason.DRESS_KEY_CHANGED);
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.servlet.m
    public void a(boolean success, List<String> uinList) {
        String joinToString$default;
        Set<String> set;
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Source f16 = f();
        List<String> list = uinList;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager$onUserAppearanceKeyChange$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String a16 = i.a(it);
                return a16 != null ? a16 : "";
            }
        }, 31, null);
        QLog.i("ZPlanPreRecordManager", 1, "onUserAppearanceKeyChange, uinList:" + joinToString$default + ", portalSource:" + f16);
        if (!uinList.isEmpty()) {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            set = CollectionsKt___CollectionsKt.toSet(list);
            zPlanServiceHelper.o0(set);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanPreRecordManager$onUserAppearanceKeyChange$2(f16, uinList, null), 3, null);
    }

    public final void h() {
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            return;
        }
        c16.removeObserver(this);
        c16.addObserver(this, true);
    }

    public final void k(List<String> changedUinList) {
        Intrinsics.checkNotNullParameter(changedUinList, "changedUinList");
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null && d(changedUinList)) {
            boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, c16.getLongAccountUin());
            boolean S = ZPlanFeatureSwitch.f369852a.S();
            QLog.i("ZPlanPreRecordManager", 1, "preRecordEmoticonActions, enableEmoticonScene:" + isZPlanAccessible + ", recordOnAppearanceChange:" + S);
            if (isZPlanAccessible && S) {
                ZPlanEmoticonUtil.f333176e.Z(ZPlanFeatureSwitch.Q1());
            }
        }
    }

    public final void n(a listener) {
        recordAvatarActionListener = listener;
    }

    public final void o(ji3.h listener) {
        shareRecordListener = listener;
    }
}
