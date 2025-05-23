package com.tencent.state.mmkv;

import com.tencent.state.square.Square;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated(message = "\u5df2\u7ecf\u5f03\u7528\uff0c\u76ee\u524d\u4ec5\u4fdd\u7559\u7528\u4e8e\u505a\u6570\u636e\u8fc1\u79fb\uff1b\u540e\u7eed\u8bf7\u4f7f\u7528SquareMMKV")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c3\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/mmkv/VasFilePrefix;", "", "()V", "FILE_VAS", "", "fileWithUin", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
final class VasFilePrefix {
    public static final String FILE_VAS = "vas_mmkv_configurations";
    public static final VasFilePrefix INSTANCE = new VasFilePrefix();

    VasFilePrefix() {
    }

    public final String fileWithUin() {
        return "vas_mmkv_configurations_" + Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin();
    }
}
