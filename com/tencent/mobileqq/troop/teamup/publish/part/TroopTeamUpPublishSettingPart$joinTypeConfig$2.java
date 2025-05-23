package com.tencent.mobileqq.troop.teamup.publish.part;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a;
import com.tencent.mobileqq.troop.teamup.publish.data.TroopTeamUpJoinType;
import com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "invoke", "()Lcom/tencent/mobileqq/widget/listitem/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpPublishSettingPart$joinTypeConfig$2 extends Lambda implements Function0<x<x.b.d, x.c.g>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopTeamUpPublishSettingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpPublishSettingPart$joinTypeConfig$2(TroopTeamUpPublishSettingPart troopTeamUpPublishSettingPart) {
        super(0);
        this.this$0 = troopTeamUpPublishSettingPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopTeamUpPublishSettingPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String title, TroopTeamUpPublishSettingPart this$0, View view) {
        TroopTeamUpPublishVM D9;
        List asList;
        int collectionSizeOrDefault;
        List listOf;
        List listOf2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        D9 = this$0.D9();
        MutableLiveData<TroopTeamUpJoinType> N1 = D9.N1();
        TroopTeamUpJoinType troopTeamUpJoinType = TroopTeamUpJoinType.APPLY;
        Object[] enumConstants = TroopTeamUpJoinType.class.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "E::class.java.enumConstants");
        asList = ArraysKt___ArraysJvmKt.asList(enumConstants);
        List list = asList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String string = this$0.getContext().getString(((TroopTeamUpJoinType) it.next()).getDescriptionRes());
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(it.descriptionRes)");
            arrayList.add(string);
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(arrayList);
        TroopTeamUpJoinType value = N1.getValue();
        if (value != null) {
            troopTeamUpJoinType = value;
        }
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(Math.max(asList.indexOf(troopTeamUpJoinType), 0)));
        new com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a(context, new a.b(title, listOf, listOf2), new com.tencent.mobileqq.troop.teamup.publish.d(N1, asList)).m();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final x<x.b.d, x.c.g> invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final String string = this.this$0.getContext().getString(R.string.f236397e9);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_publish_participate_way)");
        x<x.b.d, x.c.g> b16 = x.Companion.b(x.INSTANCE, string, null, 2, null);
        final TroopTeamUpPublishSettingPart troopTeamUpPublishSettingPart = this.this$0;
        b16.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpPublishSettingPart$joinTypeConfig$2.b(string, troopTeamUpPublishSettingPart, view);
            }
        });
        x.c.g O = b16.O();
        String string2 = troopTeamUpPublishSettingPart.getContext().getString(R.string.f236407e_);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026up_publish_please_choose)");
        O.h(string2);
        return b16;
    }
}
