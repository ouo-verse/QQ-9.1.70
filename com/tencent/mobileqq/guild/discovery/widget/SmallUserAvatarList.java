package com.tencent.mobileqq.guild.discovery.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.util.AppSetting;
import fh1.AvatarInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u001d\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0014\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/SmallUserAvatarList;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/guild/discovery/widget/j;", "adapter", "", "d", "e", "", "start", "count", "c", "", "Lfh1/a;", "list", "f", "Lcom/tencent/mobileqq/guild/discovery/widget/j;", "b", "()Lcom/tencent/mobileqq/guild/discovery/widget/j;", "setAdapter$qqguild_impl_release", "(Lcom/tencent/mobileqq/guild/discovery/widget/j;)V", "Landroid/database/DataSetObserver;", "Landroid/database/DataSetObserver;", "dataSetObserver", "I", "avatarSize", tl.h.F, "itemOffset", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SmallUserAvatarList extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public j adapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private DataSetObserver dataSetObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int avatarSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int itemOffset;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/discovery/widget/SmallUserAvatarList$b", "Landroid/database/DataSetObserver;", "", "onChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            SmallUserAvatarList.this.e();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmallUserAvatarList(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(int start, int count) {
        int i3 = start + count;
        if (start >= 0 && count >= 0 && i3 <= getChildCount()) {
            while (start < i3) {
                getChildAt(start).setVisibility(8);
                start++;
            }
            return;
        }
        if (!AppSetting.isPublicVersion()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "hideView invalid params, start:" + start + ", count:" + count + ", end:" + i3;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.discovery.mine.SmallUserAvatarList", 1, (String) it.next(), null);
            }
            return;
        }
        throw new IllegalArgumentException("Guild.discovery.mine.SmallUserAvatarList, hideView invalid params, start:" + start + ", count:" + count + ", end:" + i3);
    }

    private final void d(j adapter) {
        DataSetObserver dataSetObserver = null;
        if (this.adapter != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("repeat set adapter");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.discovery.mine.SmallUserAvatarList", 1, (String) it.next(), null);
            }
            return;
        }
        setAdapter$qqguild_impl_release(adapter);
        this.dataSetObserver = new b();
        j b16 = b();
        DataSetObserver dataSetObserver2 = this.dataSetObserver;
        if (dataSetObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSetObserver");
        } else {
            dataSetObserver = dataSetObserver2;
        }
        b16.registerDataSetObserver(dataSetObserver);
        b().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < b().getCount() && i3 < childCount) {
            b().getView(i3, getChildAt(i3), this);
            i3++;
        }
        if (childCount > b().getCount()) {
            c(i3, childCount - b().getCount());
        }
        if (childCount < b().getCount()) {
            while (i3 < b().getCount()) {
                View view = b().getView(i3, null, this);
                addView(view, view.getLayoutParams());
                i3++;
            }
        }
    }

    @NotNull
    public final j b() {
        j jVar = this.adapter;
        if (jVar != null) {
            return jVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final void f(@NotNull List<AvatarInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        b().c(list);
    }

    public final void setAdapter$qqguild_impl_release(@NotNull j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.adapter = jVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmallUserAvatarList(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatarSize = ViewUtils.dpToPx(17.0f);
        this.itemOffset = ViewUtils.dpToPx(4.0f);
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439645r5, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026mallUserAvatarList, 0, 0)");
        this.avatarSize = (int) obtainStyledAttributes.getDimension(up1.a.f439658s5, this.avatarSize);
        obtainStyledAttributes.recycle();
        double d16 = this.itemOffset;
        int i3 = this.avatarSize;
        this.itemOffset = (int) (d16 * (i3 / i3));
        d(new j(this.avatarSize, this.itemOffset));
    }

    public /* synthetic */ SmallUserAvatarList(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
