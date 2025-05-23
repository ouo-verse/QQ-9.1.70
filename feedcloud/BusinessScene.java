package feedcloud;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum BusinessScene implements WireEnum {
    BUSINESS_SCENE_CUSTOM(0),
    BUSINESS_SCENE_COMMENT(1),
    BUSINESS_SCENE_FEED_INTRO(2);

    public static final ProtoAdapter<BusinessScene> ADAPTER = new EnumAdapter<BusinessScene>() { // from class: feedcloud.BusinessScene.a
        {
            Syntax syntax = Syntax.PROTO_3;
            BusinessScene businessScene = BusinessScene.BUSINESS_SCENE_CUSTOM;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusinessScene fromValue(int i3) {
            return BusinessScene.fromValue(i3);
        }
    };
    private final int value;

    BusinessScene(int i3) {
        this.value = i3;
    }

    public static BusinessScene fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return BUSINESS_SCENE_FEED_INTRO;
            }
            return BUSINESS_SCENE_COMMENT;
        }
        return BUSINESS_SCENE_CUSTOM;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
