package hd;

import android.widget.CompoundButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lhd/d;", "Lhd/b;", "", "e", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setConfigKey", "(Ljava/lang/String;)V", "configKey", "", "f", "Z", "d", "()Z", "setDefaultState", "(Z)V", "defaultState", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "g", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "onCheckedChangeListener", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/CompoundButton$OnCheckedChangeListener;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String configKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean defaultState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    public /* synthetic */ d(String str, String str2, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, z16, (i3 & 8) != 0 ? null : onCheckedChangeListener);
    }

    /* renamed from: c, reason: from getter */
    public final String getConfigKey() {
        return this.configKey;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getDefaultState() {
        return this.defaultState;
    }

    /* renamed from: e, reason: from getter */
    public final CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String name, String configKey, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super(name, "", 2);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        this.configKey = configKey;
        this.defaultState = z16;
        this.onCheckedChangeListener = onCheckedChangeListener;
    }
}
