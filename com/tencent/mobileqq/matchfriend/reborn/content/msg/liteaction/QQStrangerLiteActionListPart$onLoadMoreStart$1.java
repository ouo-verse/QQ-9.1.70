package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import android.widget.RelativeLayout;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "Lkotlin/collections/ArrayList;", "list", "", "isFinish", "isFirstDisplay", "", "invoke", "(Ljava/util/ArrayList;ZZ)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes33.dex */
final class QQStrangerLiteActionListPart$onLoadMoreStart$1 extends Lambda implements Function3<ArrayList<QQStrangerLiteActionModel>, Boolean, Boolean, Unit> {
    final /* synthetic */ QQStrangerLiteActionListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerLiteActionListPart$onLoadMoreStart$1(QQStrangerLiteActionListPart qQStrangerLiteActionListPart) {
        super(3);
        this.this$0 = qQStrangerLiteActionListPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z16, QQStrangerLiteActionListPart this$0) {
        SkinnableRecycleView skinnableRecycleView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            skinnableRecycleView = this$0.recyclerView;
            if (skinnableRecycleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                skinnableRecycleView = null;
            }
            skinnableRecycleView.scrollToPosition(0);
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<QQStrangerLiteActionModel> arrayList, Boolean bool, Boolean bool2) {
        invoke(arrayList, bool.booleanValue(), bool2.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ArrayList<QQStrangerLiteActionModel> list, boolean z16, final boolean z17) {
        z72.d dVar;
        z72.c cVar;
        z72.d dVar2;
        z72.d dVar3;
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(list, "list");
        dVar = this.this$0.loadMoreAdapter;
        RelativeLayout relativeLayout2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            dVar = null;
        }
        dVar.setLoadState(false, !z16);
        cVar = this.this$0.viewAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            cVar = null;
        }
        ArrayList arrayList = new ArrayList(list);
        final QQStrangerLiteActionListPart qQStrangerLiteActionListPart = this.this$0;
        cVar.setItems(arrayList, new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.j
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerLiteActionListPart$onLoadMoreStart$1.b(z17, qQStrangerLiteActionListPart);
            }
        });
        if (z16 || list.isEmpty()) {
            dVar2 = this.this$0.loadMoreAdapter;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                dVar2 = null;
            }
            dVar2.onLoadMoreEnd(false);
            if (list.isEmpty()) {
                dVar3 = this.this$0.loadMoreAdapter;
                if (dVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                    dVar3 = null;
                }
                dVar3.hide();
                relativeLayout = this.this$0.emptyRootView;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyRootView");
                } else {
                    relativeLayout2 = relativeLayout;
                }
                relativeLayout2.setVisibility(0);
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLiteActionPullAllEvent(list));
    }
}
