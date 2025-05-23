package feedcloud;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* loaded from: classes28.dex */
public enum PromptBusiness implements WireEnum {
    PROMPT_BUSINESS_UNKNOWN(0),
    PROMPT_BUSINESS_COMMENT_STICKER_RECOMMAND(10);

    public static final ProtoAdapter<PromptBusiness> ADAPTER = new EnumAdapter<PromptBusiness>() { // from class: feedcloud.PromptBusiness.a
        {
            Syntax syntax = Syntax.PROTO_3;
            PromptBusiness promptBusiness = PromptBusiness.PROMPT_BUSINESS_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PromptBusiness fromValue(int i3) {
            return PromptBusiness.fromValue(i3);
        }
    };
    private final int value;

    PromptBusiness(int i3) {
        this.value = i3;
    }

    public static PromptBusiness fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 10) {
                return null;
            }
            return PROMPT_BUSINESS_COMMENT_STICKER_RECOMMAND;
        }
        return PROMPT_BUSINESS_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
