package com.tencent.mobileqq.search.business.contact.part;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/part/d;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "p0", "p1", "", "b", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d extends DiffUtil.ItemCallback<UIType> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(@NotNull UIType p06, @NotNull UIType p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        if ((p06 instanceof UIType.a) && (p16 instanceof UIType.a)) {
            UIType.a aVar = (UIType.a) p06;
            if (aVar.getItemData().b(((UIType.a) p16).getItemData()) && aVar.d((UIType.b) p16)) {
                return true;
            }
            return false;
        }
        if ((p06 instanceof UIType.f) && (p16 instanceof UIType.f)) {
            UIType.f fVar = (UIType.f) p06;
            if (fVar.getItemData().b(((UIType.f) p16).getItemData()) && fVar.d((UIType.b) p16)) {
                return true;
            }
            return false;
        }
        if ((p06 instanceof UIType.TitleUI) && (p16 instanceof UIType.TitleUI)) {
            UIType.TitleUI titleUI = (UIType.TitleUI) p06;
            UIType.TitleUI titleUI2 = (UIType.TitleUI) p16;
            if (TextUtils.equals(titleUI.getTitle(), titleUI2.getTitle()) && titleUI.getIsGapTop() == titleUI2.getIsGapTop()) {
                return true;
            }
            return false;
        }
        if ((p06 instanceof UIType.LoadMoreUI) && (p16 instanceof UIType.LoadMoreUI)) {
            if (((UIType.LoadMoreUI) p06).getCollapse() == ((UIType.LoadMoreUI) p16).getCollapse()) {
                return true;
            }
            return false;
        }
        return Intrinsics.areEqual(p06, p16);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(@NotNull UIType p06, @NotNull UIType p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(p06.getClass()), Reflection.getOrCreateKotlinClass(p16.getClass()))) {
            return false;
        }
        if ((p06 instanceof UIType.a) && (p16 instanceof UIType.a)) {
            return Intrinsics.areEqual(((UIType.a) p06).getItemData(), ((UIType.a) p16).getItemData());
        }
        if ((p06 instanceof UIType.f) && (p16 instanceof UIType.f)) {
            return Intrinsics.areEqual(((UIType.f) p06).getItemData(), ((UIType.f) p16).getItemData());
        }
        if ((p06 instanceof UIType.TitleUI) && (p16 instanceof UIType.TitleUI)) {
            return true;
        }
        if ((!(p06 instanceof UIType.LoadMoreUI) || !(p16 instanceof UIType.LoadMoreUI)) && p06 != p16) {
            return false;
        }
        return true;
    }
}
