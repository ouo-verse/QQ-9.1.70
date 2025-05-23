package com.tencent.qqnt.chats.biz.publicaccount;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.publicaccount.part.PASummaryConvertProcessor;
import com.tencent.qqnt.chats.biz.publicaccount.part.c;
import com.tencent.qqnt.chats.data.converter.e;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.processor.part.d;
import com.tencent.qqnt.chats.utils.h;
import cooperation.qzone.util.QZoneImageUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/PublicAccountConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QZoneImageUtils.KEY_MATCH, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "update", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "a", "Ljava/util/List;", "mPartProcessorList", "b", "mBizProcessorList", "<init>", "()V", "c", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class PublicAccountConvertProcessor extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_PAConvertProcessor.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<g>> f354368d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> mPartProcessorList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> mBizProcessorList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/PublicAccountConvertProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.publicaccount.PublicAccountConvertProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37445);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<g>> arrayList = new ArrayList<>();
        f354368d = arrayList;
        arrayList.add(com.tencent.mobileqq.qqgamepub.nt.chat.a.class);
    }

    public PublicAccountConvertProcessor() {
        List<g> listOf;
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new g[]{new d(), new com.tencent.qqnt.chats.biz.publicaccount.part.b(), new com.tencent.qqnt.chats.biz.publicaccount.part.d(), new PASummaryConvertProcessor(), new c(), new com.tencent.qqnt.chats.data.processor.part.e()});
            this.mPartProcessorList = listOf;
            ArrayList<Class<g>> arrayList = f354368d;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
                Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
                first = ArraysKt___ArraysKt.first(constructors);
                Object newInstance = ((Constructor) first).newInstance(new Object[0]);
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.data.converter.IPartConvertProcessor");
                arrayList2.add((g) newInstance);
            }
            this.mBizProcessorList = arrayList2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        return a.f354371a.a(item.n());
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
        for (final g gVar : this.mPartProcessorList) {
            if (com.tencent.qqnt.chats.utils.g.f355548a.a(params.d(), gVar)) {
                h.f355549a.d("PublicAccountConvertProcessor-" + gVar.getClass().getSimpleName(), QLog.isColorLevel(), 30000, new Function0<Unit>(item, params) { // from class: com.tencent.qqnt.chats.biz.publicaccount.PublicAccountConvertProcessor$update$1
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
                            iPatchRedirector2.redirect((short) 1, this, g.this, item, params);
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
                            g.this.update(this.$item, this.$params);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
        for (final g gVar2 : this.mBizProcessorList) {
            if (com.tencent.qqnt.chats.utils.g.f355548a.a(params.d(), gVar2)) {
                h.f355549a.d("PublicAccountConvertProcessor-" + gVar2.getClass().getSimpleName(), QLog.isColorLevel(), 30000, new Function0<Unit>(item, params) { // from class: com.tencent.qqnt.chats.biz.publicaccount.PublicAccountConvertProcessor$update$2
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
                            iPatchRedirector2.redirect((short) 1, this, g.this, item, params);
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
                            g.this.update(this.$item, this.$params);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
    }
}
