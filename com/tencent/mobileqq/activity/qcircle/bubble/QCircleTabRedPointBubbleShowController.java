package com.tencent.mobileqq.activity.qcircle.bubble;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.UiThread;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.RedPointInfoExtKt;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;
import qqcircle.QQCircleCounterStyle$StyleBubble;
import qqcircle.QQCircleCounterStyle$StyleIcon;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bC\u0010>J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J0\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002JR\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0019\u001a\u00020\u00162\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00132\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u001f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001c\u0010\"\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#H\u0002J\u001d\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010'\u001a\u00020&H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010,\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010*H\u0007J\f\u0010-\u001a\u00020\u001d*\u00020&H\u0002R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u0014048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010?\u001a\u00020\u001d8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\u001a\u0010B\u001a\u00020\u001d8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bA\u0010>\u001a\u0004\b@\u0010<\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/QCircleTabRedPointBubbleShowController;", "", "Lcom/tencent/mobileqq/app/FrameFragment;", "frameFragment", "Lqqcircle/QQCircleCounter$RedPointInfo;", "redPointInfo", "Lcom/tencent/mobileqq/activity/qcircle/bubble/n;", "callback", "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/activity/qcircle/bubble/RedPointDismissSource;", "source", "p", "", "operateId", "Lqqcircle/QQCircleCounterStyle$StyleBubble;", "styleBubble", "timeoutMills", "y", "", "Landroid/graphics/drawable/Drawable;", "downloadedDrawableList", "", "iconUrlSize", "r", "urlSize", "Lqqcircle/QQCircleCounterMsg$RedDisplayInfo;", "redDisplayInfoList", "w", "", "loadImageTimeout", "o", "Lcom/tencent/mobileqq/activity/qcircle/bubble/BubbleFailReason;", "failReason", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/qcircle/bubble/k;", "bubbleInfo", "t", "", "url", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", "Lcom/tencent/mobileqq/activity/qcircle/bubble/e;", "b", "Lcom/tencent/mobileqq/activity/qcircle/bubble/e;", "redPointBubbleImplStrategy", "c", "J", "", "d", "Ljava/util/List;", "strongReferenceDrawableList", "e", "Lqqcircle/QQCircleCounter$RedPointInfo;", "pendingBubbleInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "getBubbleClicked$annotations", "()V", "bubbleClicked", "v", "isShowing$annotations", "isShowing", "<init>", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QCircleTabRedPointBubbleShowController {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long operateId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static QQCircleCounter$RedPointInfo pendingBubbleInfo;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QCircleTabRedPointBubbleShowController f184502a = new QCircleTabRedPointBubbleShowController();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e redPointBubbleImplStrategy = new j();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<Drawable> strongReferenceDrawableList = new ArrayList();

    QCircleTabRedPointBubbleShowController() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(final n callback, final BubbleFailReason failReason) {
        com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$callbackFailed$1
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
                QCircleTabRedPointBubbleShowController.pendingBubbleInfo = null;
                n nVar = n.this;
                if (nVar != null) {
                    nVar.b(failReason);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(QCircleTabRedPointBubbleShowController qCircleTabRedPointBubbleShowController, n nVar, BubbleFailReason bubbleFailReason, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bubbleFailReason = BubbleFailReason.OTHER;
        }
        qCircleTabRedPointBubbleShowController.m(nVar, bubbleFailReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(final n callback, final boolean loadImageTimeout) {
        com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$callbackSucceed$1
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
                QCircleTabRedPointBubbleShowController.pendingBubbleInfo = null;
                n nVar = n.this;
                if (nVar != null) {
                    nVar.a(loadImageTimeout);
                }
            }
        });
    }

    @JvmStatic
    public static final void p(@NotNull final RedPointDismissSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$dismiss$1
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
                long j3;
                long j16;
                List list;
                e eVar;
                j3 = QCircleTabRedPointBubbleShowController.operateId;
                QCircleTabRedPointBubbleShowController.operateId = j3 + 1;
                j16 = QCircleTabRedPointBubbleShowController.operateId;
                QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "dismiss, operateId=" + j16);
                list = QCircleTabRedPointBubbleShowController.strongReferenceDrawableList;
                list.clear();
                eVar = QCircleTabRedPointBubbleShowController.redPointBubbleImplStrategy;
                eVar.j(RedPointDismissSource.this);
            }
        });
    }

    public static final boolean q() {
        return redPointBubbleImplStrategy.get_bubbleClicked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<Drawable> r(List<? extends Drawable> downloadedDrawableList, int iconUrlSize) {
        List<Drawable> emptyList;
        if (downloadedDrawableList.isEmpty() || downloadedDrawableList.size() != iconUrlSize) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return downloadedDrawableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(final String str, Continuation<? super Drawable> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (f184502a.u(str)) {
            obtain.mPlayGifImage = true;
        }
        final URLDrawable urlDrawable = URLDrawable.getDrawable(str, obtain);
        List<Drawable> list = strongReferenceDrawableList;
        Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
        list.add(urlDrawable);
        if (urlDrawable.getStatus() == 1) {
            QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "getDrawable, memory cache, url = " + str);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(urlDrawable.getCurrDrawable()));
        } else {
            urlDrawable.setURLDrawableListener(new a(str, safeContinuation));
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$getDrawable$2$2
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "getDrawable, startDownload, url = " + str);
                    urlDrawable.downloadImediatly();
                }
            }, 16, null, false);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t(QCircleTabRedPointBubbleInfo bubbleInfo) {
        long serverTime = NetConnInfoCenter.getServerTime();
        if (bubbleInfo.getExpiredTime() < serverTime) {
            QLog.i("QCircleTabRedPoint.BubbleImplStrategy", 1, "showBubble failed, popExpired, currentTime=" + serverTime + ", expiredTime=" + bubbleInfo.getExpiredTime());
            return true;
        }
        return false;
    }

    private final boolean u(String str) {
        boolean endsWith;
        endsWith = StringsKt__StringsJVMKt.endsWith(str, QzoneEmotionUtils.SIGN_ICON_URL_END, true);
        return endsWith;
    }

    public static final boolean v() {
        return redPointBubbleImplStrategy.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(long operateId2, final FrameFragment frameFragment, QQCircleCounterStyle$StyleBubble styleBubble, List<? extends Drawable> downloadedDrawableList, final int urlSize, List<QQCircleCounterMsg$RedDisplayInfo> redDisplayInfoList, final n callback) {
        long j3 = operateId;
        if (operateId2 != j3) {
            QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "showBubble failed, operateId=" + operateId2 + ", curOperateId=" + j3);
            n(this, callback, null, 2, null);
            return;
        }
        QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "showBubble, downloadedDrawableSize=" + downloadedDrawableList.size() + ", urlSize=" + urlSize + ", redDisplayInfoSize=" + redDisplayInfoList.size());
        final List<Drawable> r16 = r(downloadedDrawableList, urlSize);
        final QCircleTabRedPointBubbleInfo a16 = QCircleTabRedPointBubbleInfo.INSTANCE.a(styleBubble, r16, redDisplayInfoList);
        QCircleTianShuBubbleChecker.f184511a.c(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$showBubble$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                boolean t16;
                e eVar;
                if (!z16) {
                    QCircleTabRedPointBubbleShowController.f184502a.m(callback, BubbleFailReason.INTERCEPTED);
                    return;
                }
                QCircleTabRedPointBubbleShowController qCircleTabRedPointBubbleShowController = QCircleTabRedPointBubbleShowController.f184502a;
                t16 = qCircleTabRedPointBubbleShowController.t(QCircleTabRedPointBubbleInfo.this);
                if (t16) {
                    qCircleTabRedPointBubbleShowController.m(callback, BubbleFailReason.EXPIRED);
                    return;
                }
                eVar = QCircleTabRedPointBubbleShowController.redPointBubbleImplStrategy;
                FrameFragment frameFragment2 = frameFragment;
                QCircleTabRedPointBubbleInfo qCircleTabRedPointBubbleInfo = QCircleTabRedPointBubbleInfo.this;
                final n nVar = callback;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$showBubble$2$isSucceeded$1
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
                        n nVar2 = n.this;
                        if (nVar2 != null) {
                            nVar2.onDismiss();
                        }
                    }
                };
                final n nVar2 = callback;
                if (eVar.p(frameFragment2, qCircleTabRedPointBubbleInfo, function0, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$showBubble$2$isSucceeded$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        n nVar3 = n.this;
                        if (nVar3 != null) {
                            nVar3.onClick();
                        }
                    }
                })) {
                    qCircleTabRedPointBubbleShowController.o(callback, r16.size() < urlSize);
                } else {
                    QCircleTabRedPointBubbleShowController.n(qCircleTabRedPointBubbleShowController, callback, null, 2, null);
                }
            }
        });
    }

    @JvmStatic
    public static final void x(@NotNull final FrameFragment frameFragment, @NotNull final QQCircleCounter$RedPointInfo redPointInfo, @NotNull final n callback) {
        Intrinsics.checkNotNullParameter(frameFragment, "frameFragment");
        Intrinsics.checkNotNullParameter(redPointInfo, "redPointInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController$showBubble$1
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
                QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
                long j3;
                long j16;
                List emptyList;
                long j17;
                QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2 = QQCircleCounter$RedPointInfo.this;
                qQCircleCounter$RedPointInfo = QCircleTabRedPointBubbleShowController.pendingBubbleInfo;
                if (RedPointInfoExtKt.isSameBubble(qQCircleCounter$RedPointInfo2, qQCircleCounter$RedPointInfo)) {
                    return;
                }
                QCircleTabRedPointBubbleShowController.pendingBubbleInfo = QQCircleCounter$RedPointInfo.this;
                j3 = QCircleTabRedPointBubbleShowController.operateId;
                QCircleTabRedPointBubbleShowController.operateId = j3 + 1;
                QQCircleCounterStyle$StyleBubble styleBubble = QQCircleCounter$RedPointInfo.this.allPushInfo.styleBottomTab.bubble.get();
                int i3 = styleBubble.styleType.get();
                List<QQCircleCounterMsg$RedDisplayInfo> redDisplayInfoListForShow = QQCircleCounter$RedPointInfo.this.rptRedInfo.get();
                if (i3 == 2) {
                    QCircleTabRedPointBubbleShowController qCircleTabRedPointBubbleShowController = QCircleTabRedPointBubbleShowController.f184502a;
                    j17 = QCircleTabRedPointBubbleShowController.operateId;
                    Intrinsics.checkNotNullExpressionValue(styleBubble, "styleBubble");
                    qCircleTabRedPointBubbleShowController.y(j17, styleBubble, frameFragment, 3000L, callback);
                    return;
                }
                QCircleTabRedPointBubbleShowController qCircleTabRedPointBubbleShowController2 = QCircleTabRedPointBubbleShowController.f184502a;
                j16 = QCircleTabRedPointBubbleShowController.operateId;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                FrameFragment frameFragment2 = frameFragment;
                Intrinsics.checkNotNullExpressionValue(styleBubble, "styleBubble");
                Intrinsics.checkNotNullExpressionValue(redDisplayInfoListForShow, "redDisplayInfoListForShow");
                qCircleTabRedPointBubbleShowController2.w(j16, frameFragment2, styleBubble, emptyList, 0, redDisplayInfoListForShow, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(long operateId2, QQCircleCounterStyle$StyleBubble styleBubble, FrameFragment frameFragment, long timeoutMills, n callback) {
        Object orNull;
        List<String> list;
        List<? extends Drawable> emptyList;
        List<QQCircleCounterMsg$RedDisplayInfo> emptyList2;
        Job launch$default;
        PBRepeatField<String> pBRepeatField;
        List<QQCircleCounterStyle$StyleIcon> list2 = styleBubble.icons.get();
        Intrinsics.checkNotNullExpressionValue(list2, "styleBubble.icons.get()");
        boolean z16 = false;
        orNull = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
        QQCircleCounterStyle$StyleIcon qQCircleCounterStyle$StyleIcon = (QQCircleCounterStyle$StyleIcon) orNull;
        Integer num = null;
        if (qQCircleCounterStyle$StyleIcon != null && (pBRepeatField = qQCircleCounterStyle$StyleIcon.urls) != null) {
            list = pBRepeatField.get();
        } else {
            list = null;
        }
        if (list != null) {
            num = Integer.valueOf(list.size());
        }
        QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "showBubbleWithTimeout, timeoutMills=" + timeoutMills + ", size=" + num);
        List<String> list3 = list;
        if (list3 == null || list3.isEmpty()) {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            w(operateId2, frameFragment, styleBubble, emptyList, 0, emptyList2, callback);
        } else {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$fetchDrawableJob$1(list, arrayList, booleanRef, operateId2, frameFragment, styleBubble, size, callback, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new QCircleTabRedPointBubbleShowController$showBubbleWithTimeout$1(timeoutMills, launch$default, booleanRef, operateId2, frameFragment, styleBubble, arrayList, size, callback, null), 3, null);
        }
    }

    @JvmStatic
    @UiThread
    public static final void z(@Nullable Activity activity) {
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/activity/qcircle/bubble/QCircleTabRedPointBubbleShowController$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "progress", "", "onLoadProgressed", "onLoadSuccessed", "onLoadCanceled", "", "throwable", "onLoadFialed", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f184507d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Continuation<Drawable> f184508e;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Continuation<? super Drawable> continuation) {
            this.f184507d = str;
            this.f184508e = continuation;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            Drawable drawable2;
            QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "getDrawable, onLoadCanceled, url = " + this.f184507d);
            Continuation<Drawable> continuation = this.f184508e;
            Result.Companion companion = Result.INSTANCE;
            if (drawable != null) {
                drawable2 = drawable.getCurrDrawable();
            } else {
                drawable2 = null;
            }
            continuation.resumeWith(Result.m476constructorimpl(drawable2));
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable throwable) {
            QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "getDrawable, onLoadFialed, url = " + this.f184507d);
            this.f184508e.resumeWith(Result.m476constructorimpl(null));
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            Drawable drawable2;
            QLog.i("QCircleTabRedPoint.BubbleShowController", 1, "getDrawable, onLoadSuccessed, url = " + this.f184507d);
            Continuation<Drawable> continuation = this.f184508e;
            Result.Companion companion = Result.INSTANCE;
            if (drawable != null) {
                drawable2 = drawable.getCurrDrawable();
            } else {
                drawable2 = null;
            }
            continuation.resumeWith(Result.m476constructorimpl(drawable2));
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
        }
    }
}
