package feedcloud;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* loaded from: classes28.dex */
public enum TextPreProcessAct implements WireEnum {
    TEXT_PREPROCESS_ACT_UNKNOWN(0),
    TEXT_PREPROCESS_ACT_JIEBA_EXTRACT(1),
    TEXT_PREPROCESS_ACT_PROMPT(2);

    public static final ProtoAdapter<TextPreProcessAct> ADAPTER = new EnumAdapter<TextPreProcessAct>() { // from class: feedcloud.TextPreProcessAct.a
        {
            Syntax syntax = Syntax.PROTO_3;
            TextPreProcessAct textPreProcessAct = TextPreProcessAct.TEXT_PREPROCESS_ACT_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextPreProcessAct fromValue(int i3) {
            return TextPreProcessAct.fromValue(i3);
        }
    };
    private final int value;

    TextPreProcessAct(int i3) {
        this.value = i3;
    }

    public static TextPreProcessAct fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return TEXT_PREPROCESS_ACT_PROMPT;
            }
            return TEXT_PREPROCESS_ACT_JIEBA_EXTRACT;
        }
        return TEXT_PREPROCESS_ACT_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
