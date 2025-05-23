package feedcloud;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* loaded from: classes28.dex */
public enum PredefinedPipeline implements WireEnum {
    PREDEFINED_PIPELINE_CUSTOM(0),
    PREDEFINED_PIPELINE_NOOP(1),
    PREDEFINED_PIPELINE_JIEBA_TOP3(100),
    PREDEFINED_PIPELINE_COMMENT_PROMPT(101);

    public static final ProtoAdapter<PredefinedPipeline> ADAPTER = new EnumAdapter<PredefinedPipeline>() { // from class: feedcloud.PredefinedPipeline.a
        {
            Syntax syntax = Syntax.PROTO_3;
            PredefinedPipeline predefinedPipeline = PredefinedPipeline.PREDEFINED_PIPELINE_CUSTOM;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PredefinedPipeline fromValue(int i3) {
            return PredefinedPipeline.fromValue(i3);
        }
    };
    private final int value;

    PredefinedPipeline(int i3) {
        this.value = i3;
    }

    public static PredefinedPipeline fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 100) {
                    if (i3 != 101) {
                        return null;
                    }
                    return PREDEFINED_PIPELINE_COMMENT_PROMPT;
                }
                return PREDEFINED_PIPELINE_JIEBA_TOP3;
            }
            return PREDEFINED_PIPELINE_NOOP;
        }
        return PREDEFINED_PIPELINE_CUSTOM;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
