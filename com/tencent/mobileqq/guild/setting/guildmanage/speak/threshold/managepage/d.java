package com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sz1.JoinTimeItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0007H\u0016J$\u0010\u0011\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/d;", "Landroid/widget/BaseAdapter;", "", "Lsz1/a;", "list", "", "setData", "", "getCount", "position", "a", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "e", "Ljava/util/List;", "items", "Landroid/content/res/ColorStateList;", "f", "Landroid/content/res/ColorStateList;", "textColorStateList", "<init>", "(Landroid/content/Context;)V", tl.h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<JoinTimeItem> items;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ColorStateList textColorStateList;

    public d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.items = new ArrayList();
        ColorStateList colorStateList = ResourcesCompat.getColorStateList(context.getResources(), R.color.guild_skin_content_text, context.getTheme());
        Intrinsics.checkNotNull(colorStateList);
        this.textColorStateList = colorStateList;
    }

    @Override // android.widget.Adapter
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JoinTimeItem getItem(int position) {
        return this.items.get(position);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        WheelTextView wheelTextView = (WheelTextView) convertView;
        if (wheelTextView == null) {
            wheelTextView = new WheelTextView(this.context);
            wheelTextView.setLayoutParams(new VerticalGallery.LayoutParams(-1, x.c(this.context, 45.0f)));
            wheelTextView.setFocusable(true);
            wheelTextView.setFocusableInTouchMode(true);
        }
        String desc = this.items.get(position).getDesc();
        wheelTextView.setTextSize(17.0f);
        wheelTextView.setTextColor(this.textColorStateList);
        wheelTextView.setGravity(17);
        wheelTextView.setText(desc);
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return wheelTextView;
    }

    public final void setData(@NotNull List<JoinTimeItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
