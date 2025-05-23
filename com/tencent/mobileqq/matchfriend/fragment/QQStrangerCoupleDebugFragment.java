package com.tencent.mobileqq.matchfriend.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager;
import com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManagerProvider;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0004\n\u0002\b\u000e*\u0002&*\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010#R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/fragment/QQStrangerCoupleDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "text", "Landroid/view/View$OnClickListener;", "click", "Landroid/widget/TextView;", "Ch", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "actionLayout", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/QQCoupleManager;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "D", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/QQCoupleManager;", "manager", "E", "Landroid/widget/TextView;", "observer1", UserInfo.SEX_FEMALE, "observer2", "G", "Ljava/lang/String;", "coupleId", "H", "I", "markId1", "markId2", "com/tencent/mobileqq/matchfriend/fragment/QQStrangerCoupleDebugFragment$listener1$1", "J", "Lcom/tencent/mobileqq/matchfriend/fragment/QQStrangerCoupleDebugFragment$listener1$1;", "listener1", "com/tencent/mobileqq/matchfriend/fragment/QQStrangerCoupleDebugFragment$listener2$1", "K", "Lcom/tencent/mobileqq/matchfriend/fragment/QQStrangerCoupleDebugFragment$listener2$1;", "listener2", "L", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "mock1", "M", "mock2", "<init>", "()V", "N", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerCoupleDebugFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout actionLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private QQCoupleManager<QQStrangerInteractiveMarkModel> manager;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView observer1;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView observer2;

    /* renamed from: G, reason: from kotlin metadata */
    private final String coupleId = "10086";

    /* renamed from: H, reason: from kotlin metadata */
    private final int markId1 = 1;

    /* renamed from: I, reason: from kotlin metadata */
    private final int markId2 = 2;

    /* renamed from: J, reason: from kotlin metadata */
    private final QQStrangerCoupleDebugFragment$listener1$1 listener1 = new com.tencent.mobileqq.matchfriend.reborn.couple.a<QQStrangerInteractiveMarkModel>() { // from class: com.tencent.mobileqq.matchfriend.fragment.QQStrangerCoupleDebugFragment$listener1$1
        @Override // com.tencent.mobileqq.matchfriend.reborn.couple.a
        public void a(final List<? extends QQStrangerInteractiveMarkModel> coupleList) {
            Intrinsics.checkNotNullParameter(coupleList, "coupleList");
            final QQStrangerCoupleDebugFragment qQStrangerCoupleDebugFragment = QQStrangerCoupleDebugFragment.this;
            com.tencent.av.zplan.avatar.utils.f.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.fragment.QQStrangerCoupleDebugFragment$listener1$1$onCoupleUpdate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    TextView textView;
                    int i3;
                    int i16;
                    List<QQStrangerInteractiveMarkModel> list = coupleList;
                    QQStrangerCoupleDebugFragment qQStrangerCoupleDebugFragment2 = qQStrangerCoupleDebugFragment;
                    String str = "";
                    for (QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel : list) {
                        String str2 = qQStrangerInteractiveMarkModel.subtype;
                        i3 = qQStrangerCoupleDebugFragment2.markId1;
                        if (Intrinsics.areEqual(str2, String.valueOf(i3))) {
                            qQStrangerCoupleDebugFragment2.mock1 = qQStrangerInteractiveMarkModel;
                        }
                        String str3 = qQStrangerInteractiveMarkModel.subtype;
                        i16 = qQStrangerCoupleDebugFragment2.markId2;
                        if (Intrinsics.areEqual(str3, String.valueOf(i16))) {
                            qQStrangerCoupleDebugFragment2.mock2 = qQStrangerInteractiveMarkModel;
                        }
                        str = ((Object) str) + qQStrangerInteractiveMarkModel + "\n";
                    }
                    textView = qQStrangerCoupleDebugFragment.observer1;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("observer1");
                        textView = null;
                    }
                    textView.setText(str);
                }
            });
        }
    };

    /* renamed from: K, reason: from kotlin metadata */
    private final QQStrangerCoupleDebugFragment$listener2$1 listener2 = new com.tencent.mobileqq.matchfriend.reborn.couple.a<QQStrangerInteractiveMarkModel>() { // from class: com.tencent.mobileqq.matchfriend.fragment.QQStrangerCoupleDebugFragment$listener2$1
        @Override // com.tencent.mobileqq.matchfriend.reborn.couple.a
        public void a(final List<? extends QQStrangerInteractiveMarkModel> coupleList) {
            Intrinsics.checkNotNullParameter(coupleList, "coupleList");
            final QQStrangerCoupleDebugFragment qQStrangerCoupleDebugFragment = QQStrangerCoupleDebugFragment.this;
            com.tencent.av.zplan.avatar.utils.f.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.fragment.QQStrangerCoupleDebugFragment$listener2$1$onCoupleUpdate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    TextView textView;
                    int i3;
                    int i16;
                    List<QQStrangerInteractiveMarkModel> list = coupleList;
                    QQStrangerCoupleDebugFragment qQStrangerCoupleDebugFragment2 = qQStrangerCoupleDebugFragment;
                    String str = "";
                    for (QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel : list) {
                        String str2 = qQStrangerInteractiveMarkModel.subtype;
                        i3 = qQStrangerCoupleDebugFragment2.markId1;
                        if (Intrinsics.areEqual(str2, String.valueOf(i3))) {
                            qQStrangerCoupleDebugFragment2.mock1 = qQStrangerInteractiveMarkModel;
                        }
                        String str3 = qQStrangerInteractiveMarkModel.subtype;
                        i16 = qQStrangerCoupleDebugFragment2.markId2;
                        if (Intrinsics.areEqual(str3, String.valueOf(i16))) {
                            qQStrangerCoupleDebugFragment2.mock2 = qQStrangerInteractiveMarkModel;
                        }
                        str = ((Object) str) + qQStrangerInteractiveMarkModel + "\n";
                    }
                    textView = qQStrangerCoupleDebugFragment.observer2;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("observer2");
                        textView = null;
                    }
                    textView.setText(str);
                }
            });
        }
    };

    /* renamed from: L, reason: from kotlin metadata */
    private QQStrangerInteractiveMarkModel mock1;

    /* renamed from: M, reason: from kotlin metadata */
    private QQStrangerInteractiveMarkModel mock2;

    private final TextView Ch(String text, View.OnClickListener click) {
        TextView textView = new TextView(getContext());
        ViewGroup viewGroup = null;
        textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_text_primary_selector, null));
        textView.setTextSize(17.0f);
        textView.setGravity(17);
        textView.setText(text);
        textView.setOnClickListener(click);
        LinearLayout linearLayout = this.actionLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
        } else {
            viewGroup = linearLayout;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = l.b(10);
        Unit unit = Unit.INSTANCE;
        viewGroup.addView(textView, layoutParams);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(final QQStrangerCoupleDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this$0.manager;
        if (qQCoupleManager != null) {
            qQCoupleManager.f(this$0.coupleId, new Function1<List<? extends QQStrangerInteractiveMarkModel>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.fragment.QQStrangerCoupleDebugFragment$onViewCreated$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends QQStrangerInteractiveMarkModel> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.String] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends QQStrangerInteractiveMarkModel> couple) {
                    int i3;
                    int i16;
                    Intrinsics.checkNotNullParameter(couple, "couple");
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = "";
                    QQStrangerCoupleDebugFragment qQStrangerCoupleDebugFragment = QQStrangerCoupleDebugFragment.this;
                    for (QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel : couple) {
                        String str = qQStrangerInteractiveMarkModel.subtype;
                        i3 = qQStrangerCoupleDebugFragment.markId1;
                        if (Intrinsics.areEqual(str, String.valueOf(i3))) {
                            qQStrangerCoupleDebugFragment.mock1 = qQStrangerInteractiveMarkModel;
                        }
                        String str2 = qQStrangerInteractiveMarkModel.subtype;
                        i16 = qQStrangerCoupleDebugFragment.markId2;
                        if (Intrinsics.areEqual(str2, String.valueOf(i16))) {
                            qQStrangerCoupleDebugFragment.mock2 = qQStrangerInteractiveMarkModel;
                        }
                        objectRef.element = objectRef.element + qQStrangerInteractiveMarkModel + "\n";
                    }
                    QLog.i("QQStrangerCoupleDebugFragment", 1, "getCouplesByCoupleId, content=" + objectRef.element);
                    final QQStrangerCoupleDebugFragment qQStrangerCoupleDebugFragment2 = QQStrangerCoupleDebugFragment.this;
                    com.tencent.av.zplan.avatar.utils.f.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.fragment.QQStrangerCoupleDebugFragment$onViewCreated$1$1.2
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
                            TextView textView;
                            textView = QQStrangerCoupleDebugFragment.this.observer1;
                            if (textView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("observer1");
                                textView = null;
                            }
                            textView.setText(objectRef.element);
                        }
                    });
                }
            });
        }
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager2 = this$0.manager;
        if (qQCoupleManager2 != null) {
            qQCoupleManager2.b(this$0.coupleId, String.valueOf(this$0.markId2), new Function1<QQStrangerInteractiveMarkModel, Unit>() { // from class: com.tencent.mobileqq.matchfriend.fragment.QQStrangerCoupleDebugFragment$onViewCreated$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
                    invoke2(qQStrangerInteractiveMarkModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
                    if (qQStrangerInteractiveMarkModel != null) {
                        final QQStrangerCoupleDebugFragment qQStrangerCoupleDebugFragment = QQStrangerCoupleDebugFragment.this;
                        qQStrangerCoupleDebugFragment.mock1 = qQStrangerInteractiveMarkModel;
                        com.tencent.av.zplan.avatar.utils.f.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.fragment.QQStrangerCoupleDebugFragment$onViewCreated$1$2$1$1
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
                                TextView textView;
                                textView = QQStrangerCoupleDebugFragment.this.observer2;
                                if (textView == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("observer2");
                                    textView = null;
                                }
                                textView.setText(qQStrangerInteractiveMarkModel.toString());
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(QQStrangerCoupleDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = this$0.mock2;
        if (qQStrangerInteractiveMarkModel != null) {
            qQStrangerInteractiveMarkModel.count += 10;
            qQStrangerInteractiveMarkModel.level++;
            QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this$0.manager;
            if (qQCoupleManager != null) {
                qQCoupleManager.A(qQStrangerInteractiveMarkModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(QQStrangerCoupleDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this$0.manager;
        if (qQCoupleManager != null) {
            qQCoupleManager.p(this$0.coupleId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(QQStrangerCoupleDebugFragment this$0, View view) {
        List<? extends QQStrangerInteractiveMarkModel> listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mock1 == null) {
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = new QQStrangerInteractiveMarkModel();
            qQStrangerInteractiveMarkModel.bizId = com.tencent.mobileqq.matchfriend.reborn.couple.model.b.f245072a.b();
            qQStrangerInteractiveMarkModel.coupleId = this$0.coupleId;
            qQStrangerInteractiveMarkModel.subtype = String.valueOf(this$0.markId1);
            qQStrangerInteractiveMarkModel.count = 0L;
            qQStrangerInteractiveMarkModel.level = 0L;
            this$0.mock1 = qQStrangerInteractiveMarkModel;
        }
        if (this$0.mock2 == null) {
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel2 = new QQStrangerInteractiveMarkModel();
            qQStrangerInteractiveMarkModel2.bizId = com.tencent.mobileqq.matchfriend.reborn.couple.model.b.f245072a.b();
            qQStrangerInteractiveMarkModel2.coupleId = this$0.coupleId;
            qQStrangerInteractiveMarkModel2.subtype = String.valueOf(this$0.markId2);
            qQStrangerInteractiveMarkModel2.count = 0L;
            qQStrangerInteractiveMarkModel2.level = 0L;
            this$0.mock2 = qQStrangerInteractiveMarkModel2;
        }
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this$0.manager;
        if (qQCoupleManager != null) {
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel3 = this$0.mock1;
            Intrinsics.checkNotNull(qQStrangerInteractiveMarkModel3);
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel4 = this$0.mock2;
            Intrinsics.checkNotNull(qQStrangerInteractiveMarkModel4);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new QQStrangerInteractiveMarkModel[]{qQStrangerInteractiveMarkModel3, qQStrangerInteractiveMarkModel4});
            qQCoupleManager.d(listOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(QQStrangerCoupleDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mock1 == null) {
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = new QQStrangerInteractiveMarkModel();
            qQStrangerInteractiveMarkModel.bizId = com.tencent.mobileqq.matchfriend.reborn.couple.model.b.f245072a.b();
            qQStrangerInteractiveMarkModel.coupleId = this$0.coupleId;
            qQStrangerInteractiveMarkModel.subtype = String.valueOf(this$0.markId1);
            qQStrangerInteractiveMarkModel.count = 0L;
            qQStrangerInteractiveMarkModel.level = 0L;
            this$0.mock1 = qQStrangerInteractiveMarkModel;
        }
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this$0.manager;
        if (qQCoupleManager != null) {
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel2 = this$0.mock1;
            Intrinsics.checkNotNull(qQStrangerInteractiveMarkModel2);
            qQCoupleManager.A(qQStrangerInteractiveMarkModel2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(QQStrangerCoupleDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mock2 == null) {
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = new QQStrangerInteractiveMarkModel();
            qQStrangerInteractiveMarkModel.bizId = com.tencent.mobileqq.matchfriend.reborn.couple.model.b.f245072a.b();
            qQStrangerInteractiveMarkModel.coupleId = this$0.coupleId;
            qQStrangerInteractiveMarkModel.subtype = String.valueOf(this$0.markId2);
            qQStrangerInteractiveMarkModel.count = 0L;
            qQStrangerInteractiveMarkModel.level = 0L;
            this$0.mock2 = qQStrangerInteractiveMarkModel;
        }
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this$0.manager;
        if (qQCoupleManager != null) {
            QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel2 = this$0.mock2;
            Intrinsics.checkNotNull(qQStrangerInteractiveMarkModel2);
            qQCoupleManager.A(qQStrangerInteractiveMarkModel2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(QQStrangerCoupleDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = this$0.mock1;
        if (qQStrangerInteractiveMarkModel != null) {
            qQStrangerInteractiveMarkModel.count += 10;
            qQStrangerInteractiveMarkModel.level++;
            QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this$0.manager;
            if (qQCoupleManager != null) {
                qQCoupleManager.A(qQStrangerInteractiveMarkModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cwz;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this.manager;
        if (qQCoupleManager != null) {
            qQCoupleManager.c(this.coupleId, "", this.listener1);
        }
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager2 = this.manager;
        if (qQCoupleManager2 != null) {
            qQCoupleManager2.c(this.coupleId, String.valueOf(this.markId2), this.listener2);
        }
        QQCoupleManagerProvider.f245049a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.manager = QQCoupleManagerProvider.f245049a.b(com.tencent.mobileqq.matchfriend.reborn.couple.model.b.f245072a.b(), QQStrangerInteractiveMarkModel.class);
        View findViewById = view.findViewById(R.id.ohz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.action_layout)");
        this.actionLayout = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.omt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.observer1)");
        this.observer1 = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.omu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.observer2)");
        this.observer2 = (TextView) findViewById3;
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager = this.manager;
        if (qQCoupleManager != null) {
            qQCoupleManager.a(this.coupleId, "", this.listener1);
        }
        QQCoupleManager<QQStrangerInteractiveMarkModel> qQCoupleManager2 = this.manager;
        if (qQCoupleManager2 != null) {
            qQCoupleManager2.a(this.coupleId, String.valueOf(this.markId2), this.listener2);
        }
        Ch("\u83b7\u53d6\u6301\u4e45\u5316\u6570\u636e", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQStrangerCoupleDebugFragment.Dh(QQStrangerCoupleDebugFragment.this, view2);
            }
        });
        Ch("\u83b7\u5f97\u5168\u90e8", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQStrangerCoupleDebugFragment.Gh(QQStrangerCoupleDebugFragment.this, view2);
            }
        });
        Ch("\u83b7\u5f97\u6807\u8bc61", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQStrangerCoupleDebugFragment.Hh(QQStrangerCoupleDebugFragment.this, view2);
            }
        });
        Ch("\u83b7\u5f97\u6807\u8bc62", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQStrangerCoupleDebugFragment.Ih(QQStrangerCoupleDebugFragment.this, view2);
            }
        });
        Ch("\u5347\u7ea7\u6807\u8bc61", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQStrangerCoupleDebugFragment.Jh(QQStrangerCoupleDebugFragment.this, view2);
            }
        });
        Ch("\u5347\u7ea7\u6807\u8bc62", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQStrangerCoupleDebugFragment.Eh(QQStrangerCoupleDebugFragment.this, view2);
            }
        });
        Ch("\u6e05\u9664\u6240\u6709", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQStrangerCoupleDebugFragment.Fh(QQStrangerCoupleDebugFragment.this, view2);
            }
        });
    }
}
