package com.tencent.state.library.components.fragments;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.privacy.StrangerPrivacyManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryStrangerPrivacyComponent$getShowDialogTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $delay;
    final /* synthetic */ long $tag;
    final /* synthetic */ LibraryStrangerPrivacyComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryStrangerPrivacyComponent$getShowDialogTask$1(LibraryStrangerPrivacyComponent libraryStrangerPrivacyComponent, long j3, long j16) {
        super(0);
        this.this$0 = libraryStrangerPrivacyComponent;
        this.$tag = j3;
        this.$delay = j16;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        QBaseActivity activity;
        AtomicBoolean atomicBoolean;
        long j3;
        AtomicBoolean atomicBoolean2;
        long j16;
        activity = this.this$0.getActivity();
        if (activity != null) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("try show dialog isStartFocus:");
            atomicBoolean = this.this$0.isStartFocus;
            sb5.append(atomicBoolean.get());
            sb5.append(", showTag:");
            j3 = this.this$0.showTag;
            sb5.append(j3);
            sb5.append(", tag:");
            sb5.append(this.$tag);
            sb5.append(", delay:");
            sb5.append(this.$delay);
            squareLog.d("LibraryStrangerPrivacyComponent", sb5.toString());
            if (activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            atomicBoolean2 = this.this$0.isStartFocus;
            if (atomicBoolean2.get()) {
                long j17 = this.$tag;
                j16 = this.this$0.showTag;
                if (j17 == j16) {
                    StrangerPrivacyManager.INSTANCE.checkAndShowDialog(activity, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryStrangerPrivacyComponent$getShowDialogTask$1$$special$$inlined$let$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                            invoke(bool.booleanValue(), num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, int i3) {
                            VasBaseFragment fragment;
                            Map<String, Object> mutableMapOf;
                            VasBaseFragment fragment2;
                            Map<String, Object> mutableMapOf2;
                            if (z16) {
                                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                                Pair[] pairArr = new Pair[2];
                                pairArr[0] = TuplesKt.to("zplan_action_type", "imp");
                                fragment2 = LibraryStrangerPrivacyComponent$getShowDialogTask$1.this.this$0.getFragment();
                                Fragment topFragment = fragment2 != null ? fragment2.getTopFragment() : null;
                                if (!(topFragment instanceof VasBaseFragment)) {
                                    topFragment = null;
                                }
                                VasBaseFragment vasBaseFragment = (VasBaseFragment) topFragment;
                                pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_POPUP_WINDOW_PG_FROM, Integer.valueOf(!Intrinsics.areEqual(SquareReportConst.PageId.PAGE_ID_LIBRARY_HOMEPAGE, vasBaseFragment != null ? vasBaseFragment.getPageId() : null) ? 1 : 0));
                                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr);
                                squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STRANGER_CAN_SEE_DIALOG, mutableMapOf2);
                                return;
                            }
                            IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                            Pair[] pairArr2 = new Pair[3];
                            pairArr2[0] = TuplesKt.to("zplan_action_type", "click");
                            pairArr2[1] = TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, Integer.valueOf(i3 == 2 ? 1 : 0));
                            fragment = LibraryStrangerPrivacyComponent$getShowDialogTask$1.this.this$0.getFragment();
                            Fragment topFragment2 = fragment != null ? fragment.getTopFragment() : null;
                            if (!(topFragment2 instanceof VasBaseFragment)) {
                                topFragment2 = null;
                            }
                            VasBaseFragment vasBaseFragment2 = (VasBaseFragment) topFragment2;
                            pairArr2[2] = TuplesKt.to(SquareReportConst.Key.KEY_POPUP_WINDOW_PG_FROM, Integer.valueOf(!Intrinsics.areEqual(SquareReportConst.PageId.PAGE_ID_LIBRARY_HOMEPAGE, vasBaseFragment2 != null ? vasBaseFragment2.getPageId() : null) ? 1 : 0));
                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr2);
                            squareReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STRANGER_CAN_SEE_DIALOG, mutableMapOf);
                        }
                    });
                }
            }
        }
    }
}
