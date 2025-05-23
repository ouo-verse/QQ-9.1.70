package com.tencent.mobileqq.chat;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatPartConvertProcessor;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/chat/SubAccountAssistantConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "c", "b", "", QZoneImageUtils.KEY_MATCH, "update", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "Ljava/util/List;", "mPartProcessorList", "<init>", "()V", "qqsubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class SubAccountAssistantConvertProcessor extends com.tencent.qqnt.chats.data.converter.e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.data.converter.g> mPartProcessorList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/chat/SubAccountAssistantConvertProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.chat.SubAccountAssistantConvertProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19988);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SubAccountAssistantConvertProcessor() {
        List<com.tencent.qqnt.chats.data.converter.g> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.chats.data.converter.g[]{(com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createSummaryConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTimeConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createUnreadConvertProcessor()});
            this.mPartProcessorList = listOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        item.g().n(2);
        item.g().l(Integer.valueOf(R.drawable.icon_recent_subaccount));
    }

    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        ArrayList arrayList = new ArrayList();
        if (item.H()) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.d());
        } else {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.q());
        }
        arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.g());
        item.O(arrayList);
    }

    private final void c(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        g.f w3 = item.w();
        String string = params.b().getString(R.string.f173172hr1);
        Intrinsics.checkNotNullExpressionValue(string, "params.context.getString\u2026subaccount_associated_qq)");
        w3.i(string);
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 131) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull final com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull final com.tencent.qqnt.chats.data.converter.c params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        for (final com.tencent.qqnt.chats.data.converter.g gVar : this.mPartProcessorList) {
            com.tencent.qqnt.chats.utils.h.f355549a.d("SubAccountAssistantConvertProcessor-" + gVar.getClass().getSimpleName(), QLog.isColorLevel(), 30000, new Function0<Unit>(item, params) { // from class: com.tencent.mobileqq.chat.SubAccountAssistantConvertProcessor$update$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.g $item;
                final /* synthetic */ com.tencent.qqnt.chats.data.converter.c $params;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$item = item;
                    this.$params = params;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, com.tencent.qqnt.chats.data.converter.g.this, item, params);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        com.tencent.qqnt.chats.data.converter.g.this.update(this.$item, this.$params);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        a(item);
        c(item, params);
        b(item);
    }
}
