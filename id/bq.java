package id;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import com.qzone.reborn.debug.timecost.QZoneDebugTimeCostFragment;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lid/bq;", "Lid/b;", "Landroid/content/Context;", "context", "", "Lhd/b;", "a", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bq extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final bq f407496a = new bq();

    bq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneDebugTimeCostFragment.class.getName()).request();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            ko.a.f412730a.d();
        } else {
            ToastUtil.r(com.qzone.util.l.a(R.string.jlv));
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // id.b
    public List<hd.b> a(final Context context) {
        List<hd.b> mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new hd.a("\u8017\u65f6\u5217\u8868", new View.OnClickListener() { // from class: id.bp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bq.h(context, view);
            }
        }));
        return mutableListOf;
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        List<hd.b> mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new hd.d("\u6253\u5f00ART Hook\u8017\u65f6\u76d1\u63a7", "KEY_ART_HOOK_ENABLE", false, new CompoundButton.OnCheckedChangeListener() { // from class: id.bo
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                bq.i(compoundButton, z16);
            }
        }), new hd.d("\u6253\u5f00\u7cfb\u7edfTrace", "KEY_SYSTEM_TRACE_ENABLE", false, null, 8, null));
        return mutableListOf;
    }
}
