package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.data.ZootopiaVersionData;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B3\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaVersionItemView;", "Landroid/widget/LinearLayout;", "", "b", "a", "Lcom/tencent/sqshow/zootopia/data/aa;", "zootopiaVersionData", "", "location", "setData", "Lfi3/ai;", "d", "Lfi3/ai;", "binding", "e", "Lcom/tencent/sqshow/zootopia/data/aa;", "versionData", "value", "f", "I", "getLocation", "()I", "setLocation", "(I)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/data/aa;Landroid/util/AttributeSet;I)V", tl.h.F, "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaVersionItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final fi3.ai binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZootopiaVersionData versionData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int location;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaVersionItemView(Context context) {
        this(context, null, null, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        int i3 = this.location;
        if (i3 == 0) {
            this.binding.f398819d.setVisibility(0);
            this.binding.f398818c.setBackgroundResource(R.drawable.h1g);
            this.binding.f398817b.setVisibility(0);
            return;
        }
        if (i3 == 1) {
            this.binding.f398819d.setVisibility(4);
            this.binding.f398818c.setBackgroundResource(R.drawable.h1d);
            this.binding.f398817b.setVisibility(0);
        } else {
            if (i3 != 3) {
                this.binding.f398819d.setVisibility(4);
                this.binding.f398818c.setBackgroundResource(R.drawable.h1d);
                this.binding.f398817b.setVisibility(4);
                this.binding.f398820e.setVisibility(8);
                return;
            }
            this.binding.f398819d.setVisibility(0);
            this.binding.f398818c.setBackgroundResource(R.drawable.h1g);
            this.binding.f398817b.setVisibility(4);
            this.binding.f398820e.setVisibility(8);
        }
    }

    private final void b() {
        String string;
        ZootopiaVersionData zootopiaVersionData = this.versionData;
        if (zootopiaVersionData != null) {
            TextView textView = this.binding.f398821f;
            int i3 = this.location;
            if (i3 != -1) {
                if (i3 != 3) {
                    string = getResources().getString(R.string.xkj, new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(zootopiaVersionData.getVersionUpdateTime() * 1000)));
                } else {
                    string = getResources().getString(R.string.xkl, new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(zootopiaVersionData.getVersionUpdateTime() * 1000)));
                }
            } else if (zootopiaVersionData.getVersionUpdateTime() == 0) {
                string = getResources().getString(R.string.xkh);
            } else {
                string = getResources().getString(R.string.xkl, new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(zootopiaVersionData.getVersionUpdateTime() * 1000)));
            }
            textView.setText(string);
            TextView textView2 = this.binding.f398820e;
            if (textView2 != null) {
                if (TextUtils.isEmpty(zootopiaVersionData.getVersionUpdateDetail())) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(zootopiaVersionData.getVersionUpdateDetail());
                }
            }
            a();
        }
    }

    public final void setData(ZootopiaVersionData zootopiaVersionData, @Companion.ZootopiaVersionItemLocation int location) {
        Intrinsics.checkNotNullParameter(zootopiaVersionData, "zootopiaVersionData");
        this.versionData = zootopiaVersionData;
        setLocation(location);
        b();
    }

    public final void setLocation(int i3) {
        this.location = i3;
        a();
    }

    public /* synthetic */ ZootopiaVersionItemView(Context context, ZootopiaVersionData zootopiaVersionData, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : zootopiaVersionData, (i16 & 4) != 0 ? null : attributeSet, (i16 & 8) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaVersionItemView(Context context, ZootopiaVersionData zootopiaVersionData, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        fi3.ai f16 = fi3.ai.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setOrientation(0);
        this.versionData = zootopiaVersionData;
        b();
    }

    public static /* synthetic */ void setData$default(ZootopiaVersionItemView zootopiaVersionItemView, ZootopiaVersionData zootopiaVersionData, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        zootopiaVersionItemView.setData(zootopiaVersionData, i3);
    }
}
