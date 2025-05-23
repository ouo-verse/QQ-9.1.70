package feedcloud;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum Switch implements WireEnum {
    NONE(0),
    PROTECTION(1),
    MEMORY_ALBUM(2);

    public static final ProtoAdapter<Switch> ADAPTER = new EnumAdapter<Switch>() { // from class: feedcloud.Switch.a
        {
            Syntax syntax = Syntax.PROTO_3;
            Switch r16 = Switch.NONE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Switch fromValue(int i3) {
            return Switch.fromValue(i3);
        }
    };
    private final int value;

    Switch(int i3) {
        this.value = i3;
    }

    public static Switch fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return MEMORY_ALBUM;
            }
            return PROTECTION;
        }
        return NONE;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
