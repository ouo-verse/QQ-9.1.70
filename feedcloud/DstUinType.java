package feedcloud;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum DstUinType implements WireEnum {
    UIN_TYPE_UNKNOWN(0),
    UIN_TYPE_UIN(1),
    UIN_TYPE_GROUP(2);

    public static final ProtoAdapter<DstUinType> ADAPTER = new EnumAdapter<DstUinType>() { // from class: feedcloud.DstUinType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            DstUinType dstUinType = DstUinType.UIN_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DstUinType fromValue(int i3) {
            return DstUinType.fromValue(i3);
        }
    };
    private final int value;

    DstUinType(int i3) {
        this.value = i3;
    }

    public static DstUinType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return UIN_TYPE_GROUP;
            }
            return UIN_TYPE_UIN;
        }
        return UIN_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
