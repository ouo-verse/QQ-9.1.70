package com.tencent.mobileqq.search.business.contact.part;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006 \u0007*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
final class ContactsSearchPart$onPartCreate$1$1 extends Lambda implements Function1<Pair<? extends List<? extends UIType>, ? extends Boolean>, Unit> {
    final /* synthetic */ ContactsSearchPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsSearchPart$onPartCreate$1$1(ContactsSearchPart contactsSearchPart) {
        super(1);
        this.this$0 = contactsSearchPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r1 = r2.binding;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(boolean z16, ContactsSearchPart this$0) {
        hp2.b bVar;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && bVar != null && (recyclerView = bVar.f405630c) != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends UIType>, ? extends Boolean> pair) {
        invoke2((Pair<? extends List<? extends UIType>, Boolean>) pair);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<? extends List<? extends UIType>, Boolean> pair) {
        Object firstOrNull;
        b bVar;
        List<? extends UIType> component1 = pair.component1();
        final boolean booleanValue = pair.component2().booleanValue();
        ContactsSearchPart contactsSearchPart = this.this$0;
        boolean isEmpty = component1.isEmpty();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) component1);
        contactsSearchPart.H9(isEmpty, (UIType) firstOrNull);
        this.this$0.broadcastMessage("action_send_uin_list", component1);
        bVar = this.this$0.adapter;
        final ContactsSearchPart contactsSearchPart2 = this.this$0;
        bVar.setItems(component1, new Runnable() { // from class: com.tencent.mobileqq.search.business.contact.part.g
            @Override // java.lang.Runnable
            public final void run() {
                ContactsSearchPart$onPartCreate$1$1.b(booleanValue, contactsSearchPart2);
            }
        });
    }
}
