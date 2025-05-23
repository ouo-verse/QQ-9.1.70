package i93;

import android.content.Intent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Li93/c;", "Lj93/b;", "Landroid/content/Intent;", "intent", "", "d", "", "", "e", "<init>", "()V", "b", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends j93.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Li93/c$a;", "", "Landroid/content/Intent;", "intent", "", "a", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: i93.c$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable Intent intent) {
            HashMap hashMap;
            String str;
            String str2;
            boolean z16;
            boolean z17;
            if (intent == null) {
                return false;
            }
            if (intent.getSerializableExtra("key_attrs") == null) {
                QLog.i("assembler", 1, "KEY_ATTRS is null");
                return false;
            }
            Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
            String str3 = null;
            if (serializableExtra instanceof HashMap) {
                hashMap = (HashMap) serializableExtra;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                str = (String) hashMap.get(QCircleScheme.AttrQQPublish.BUSINESS_TRANS_ID);
            } else {
                str = null;
            }
            if (hashMap != null) {
                str2 = (String) hashMap.get(QCircleScheme.AttrQQPublish.BUSINESS_DISPLAY_NAME);
            } else {
                str2 = null;
            }
            if (hashMap != null) {
                str3 = (String) hashMap.get("taskid");
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    return false;
                }
            }
            if (!Intrinsics.areEqual(QCircleScheme.AttrQQPublish.BUSINESS_TROOP, str3) && !Intrinsics.areEqual(QCircleScheme.AttrQQPublish.BUSINESS_GUILD, str3)) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    @Override // j93.b
    public boolean d(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return INSTANCE.a(intent);
    }

    @Override // j93.b
    @NotNull
    protected List<String> e(@NotNull Intent intent) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(intent, "intent");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"PublishSchoolPart", "PublishPromotionPart", "PublishTroopPart"});
        return listOf;
    }
}
