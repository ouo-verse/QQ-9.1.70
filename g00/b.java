package g00;

import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.f;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lg00/b;", "", "", "Lg00/a;", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "instanceStateRegisterList", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f401020a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<g00.a> instanceStateRegisterList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"g00/b$a", "Lg00/a;", "", "getKey", "value", "", HippyTextInputController.COMMAND_setValue, HippyTextInputController.COMMAND_getValue, "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements g00.a {
        a() {
        }

        @Override // g00.a
        public String getKey() {
            return "key_enter_public_acc_from";
        }

        @Override // g00.a
        public String getValue() {
            String enterPublicAccFrom = WSPublicAccReport.getInstance().getEnterPublicAccFrom();
            Intrinsics.checkNotNullExpressionValue(enterPublicAccFrom, "getInstance().enterPublicAccFrom");
            return enterPublicAccFrom;
        }

        @Override // g00.a
        public void setValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            WSPublicAccReport.getInstance().setEnterPublicAccFrom(value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"g00/b$b", "Lg00/a;", "", "getKey", "value", "", HippyTextInputController.COMMAND_setValue, HippyTextInputController.COMMAND_getValue, "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g00.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10345b implements g00.a {
        C10345b() {
        }

        @Override // g00.a
        public String getKey() {
            return "key_scene_from";
        }

        @Override // g00.a
        public String getValue() {
            String f16 = f.f();
            Intrinsics.checkNotNullExpressionValue(f16, "getSceneFrom()");
            return f16;
        }

        @Override // g00.a
        public void setValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            f.k(value);
        }
    }

    static {
        List<g00.a> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new g00.a[]{new a(), new C10345b()});
        instanceStateRegisterList = listOf;
    }

    b() {
    }

    public final List<g00.a> a() {
        return instanceStateRegisterList;
    }
}
