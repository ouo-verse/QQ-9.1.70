package com.tencent.mobileqq.guild.discoveryv2.widget.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.guild.discoveryv2.widget.webview.DiscoverNestedWebView;
import com.tencent.mobileqq.guild.home.views.embeddable.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntSpreadBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/webview/DiscoverNestedWebView;", "Lcom/tencent/biz/ui/TouchWebView;", "Lcom/tencent/mobileqq/guild/home/views/embeddable/e;", "", "direction", "", "canScrollVertically", "dX", "dY", "", "consumed", "", "c", "a", BdhLogUtil.LogTag.Tag_Conn, "[I", RemoteWebViewEvent.SCROLL_VALUES, "D", "I", "currentScrollY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DiscoverNestedWebView extends TouchWebView implements e {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private int[] scrollValues;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentScrollY;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoverNestedWebView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DiscoverNestedWebView this$0, int i3, int i16, int i17, int i18, View view) {
        int[] intArray;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean[] zArr = {this$0.canScrollVertically(-1), this$0.canScrollVertically(1), this$0.canScrollHorizontally(-1), this$0.canScrollHorizontally(1)};
        ArrayList arrayList = new ArrayList(4);
        for (int i19 = 0; i19 < 4; i19++) {
            arrayList.add(Integer.valueOf(zArr[i19] ? 1 : 0));
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            String arrays = Arrays.toString(intArray);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            Log.d("DiscoverNestedWebView", "onScrollChanged " + i3 + " " + i16 + " " + i17 + " " + i18 + " " + view + " " + arrays);
        }
        IntSpreadBuilder intSpreadBuilder = new IntSpreadBuilder(5);
        intSpreadBuilder.add(i3);
        intSpreadBuilder.add(i16);
        intSpreadBuilder.add(i17);
        intSpreadBuilder.add(i18);
        intSpreadBuilder.addSpread(intArray);
        int[] array = intSpreadBuilder.toArray();
        this$0.scrollValues = array;
        this$0.currentScrollY = array[1];
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public boolean a(int direction) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            String arrays = Arrays.toString(this.scrollValues);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            Log.d("DiscoverNestedWebView", "isHorizontalDragging(" + direction + ") " + arrays);
        }
        if (direction < 0) {
            if (this.scrollValues[7] != 1) {
                return false;
            }
            return true;
        }
        if (direction <= 0 || this.scrollValues[6] != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public void c(int dX, int dY, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        consumed[0] = dX;
        consumed[1] = dY;
    }

    @Override // android.view.View, com.tencent.mobileqq.guild.home.views.embeddable.e
    public boolean canScrollVertically(int direction) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            String arrays = Arrays.toString(this.scrollValues);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            Log.d("DiscoverNestedWebView", "canScrollVertically(" + direction + ") " + arrays);
        }
        if (direction > 0) {
            if (this.scrollValues[5] != 1) {
                return false;
            }
            return true;
        }
        if (direction >= 0 || this.scrollValues[4] != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoverNestedWebView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DiscoverNestedWebView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoverNestedWebView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scrollValues = new int[8];
        setOnScrollChangedListener(new TouchWebView.OnScrollChangedListener() { // from class: ni1.b
            @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
            public final void onScrollChanged(int i16, int i17, int i18, int i19, View view) {
                DiscoverNestedWebView.r(DiscoverNestedWebView.this, i16, i17, i18, i19, view);
            }
        });
    }
}
