package com.tencent.mobileqq.guild.discoveryv2.content.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.guild.discoveryv2.content.base.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u0000 $*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0003:\u0001%B\u0015\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0004J9\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00028\u00002\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u001a\u0010!\u001a\u00020\u001b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/a;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "I", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "e", "onCreateViewHolder", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "position", "", "", "payloads", "", "d", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;ILjava/util/List;)V", "items", "", "c", "Ljava/lang/Class;", "Ljava/lang/Class;", "getDataClass", "()Ljava/lang/Class;", "dataClass", "", "Ljava/lang/String;", "classSimpleName", "f", "b", "()Ljava/lang/String;", "x2jLayoutName", "<init>", "(Ljava/lang/Class;)V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a<I extends h> extends AbsItemAdapterDelegate<I, h> {

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f216918i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<I> dataClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String classSimpleName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String x2jLayoutName;

    static {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_mvp_feeds_x2j_enable", true);
        QLog.i("MVPFeeds", 1, "x2jEnable " + isSwitchOn);
        f216918i = isSwitchOn;
    }

    public a(@NotNull Class<I> dataClass) {
        Intrinsics.checkNotNullParameter(dataClass, "dataClass");
        this.dataClass = dataClass;
        this.classSimpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        this.x2jLayoutName = "";
    }

    private final SectionViewHolder<I> e(ViewGroup parent) {
        boolean isBlank;
        View inflate;
        isBlank = StringsKt__StringsJVMKt.isBlank(getX2jLayoutName());
        if (!isBlank) {
            inflate = ty4.b.f(parent.getContext(), getLayoutId(), getX2jLayoutName(), parent, false);
        } else {
            inflate = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        }
        ArrayList arrayList = new ArrayList();
        initSection(parent, inflate, arrayList);
        return new SectionViewHolder<>(inflate, arrayList);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public String getX2jLayoutName() {
        return this.x2jLayoutName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull h item, @NotNull List<h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return this.dataClass.isInstance(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void onBindViewHolder2(@NotNull I item, @NotNull SectionViewHolder<?> holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        uh1.a aVar = uh1.a.f438959a;
        super.onBindViewHolder((a<I>) item, (SectionViewHolder) holder, position, payloads);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public final SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        uh1.a aVar = uh1.a.f438959a;
        if (f216918i) {
            return e(parent);
        }
        SectionViewHolder<?> onCreateViewHolder = super.onCreateViewHolder(parent);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "super.onCreateViewHolder(parent)");
        return onCreateViewHolder;
    }
}
