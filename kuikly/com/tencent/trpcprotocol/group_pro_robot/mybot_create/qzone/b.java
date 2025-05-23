package kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.qzone;

import c45.d;
import c45.f;
import c45.g;
import c45.m;
import e45.c;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b implements d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f413165d = new a();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<b> {
        @Override // c45.d.a
        public final c45.b a(int i3) {
            return null;
        }

        @Override // c45.d.a
        public final b b(f fVar) {
            return new b(((c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.qzone.OpenRobotQzoneRsp$Companion$decodeWith$unknownFields$1
                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(Integer num, Object obj) {
                    num.intValue();
                    return Unit.INSTANCE;
                }
            }));
        }
    }

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.e
    public final int getProtoSize() {
        return 0;
    }

    public b(Map<Integer, m> map) {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ b(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1);
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
    }
}
