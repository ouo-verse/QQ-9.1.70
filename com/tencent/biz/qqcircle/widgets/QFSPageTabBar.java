package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSPageTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "notifyDataSetChanged", "", "d", "Ljava/lang/String;", "TAG", "", "e", "Z", "mIsConfigurationChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSPageTabBar extends QUIPageTabBar {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsConfigurationChanged;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPageTabBar(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QFSPageTabBar this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.mViewPager2;
        if (viewPager2 != null) {
            int currentPosition = this$0.getCurrentPosition();
            if (currentPosition > 0) {
                i3 = currentPosition - 1;
            } else {
                i3 = 1;
            }
            viewPager2.setCurrentItem(i3, false);
            viewPager2.setCurrentItem(currentPosition, false);
        }
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (this.mIsConfigurationChanged && bz.l()) {
            this.mIsConfigurationChanged = false;
            RFWLog.d(this.TAG, RFWLog.USR, "notifyDataSetChanged");
            post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.bd
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPageTabBar.b(QFSPageTabBar.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar, android.view.View
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        RFWLog.d(this.TAG, RFWLog.USR, "onConfigurationChanged");
        this.mIsConfigurationChanged = true;
        super.onConfigurationChanged(newConfig);
    }

    public /* synthetic */ QFSPageTabBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPageTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "QFSPageTabBar";
    }
}
