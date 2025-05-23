package feedcloud;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum RightFlag implements WireEnum {
    RIGHTFLAG_NONE(0),
    RIGHTFLAG_QQFRIEND(1),
    RIGHTFLAG_WHITELIST(2),
    RIGHTFLAG_BLACKLIST(3),
    RIGHTFLAG_NOBODY(4);

    public static final ProtoAdapter<RightFlag> ADAPTER = new EnumAdapter<RightFlag>() { // from class: feedcloud.RightFlag.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RightFlag rightFlag = RightFlag.RIGHTFLAG_NONE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RightFlag fromValue(int i3) {
            return RightFlag.fromValue(i3);
        }
    };
    private final int value;

    RightFlag(int i3) {
        this.value = i3;
    }

    public static RightFlag fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return RIGHTFLAG_NOBODY;
                    }
                    return RIGHTFLAG_BLACKLIST;
                }
                return RIGHTFLAG_WHITELIST;
            }
            return RIGHTFLAG_QQFRIEND;
        }
        return RIGHTFLAG_NONE;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
