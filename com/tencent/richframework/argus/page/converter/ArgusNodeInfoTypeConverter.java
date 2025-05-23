package com.tencent.richframework.argus.page.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tencent.richframework.argus.node.NodePO;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ArgusNodeInfoTypeConverter {
    private static final Gson gson = new GsonBuilder().create();

    @TypeConverter
    public static String blockInfoToString(NodePO nodePO) {
        return gson.toJson(nodePO);
    }

    @TypeConverter
    public String converter(List<NodePO> list) {
        return new Gson().toJson(list);
    }

    @TypeConverter
    public List<NodePO> revert(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<NodePO>>() { // from class: com.tencent.richframework.argus.page.converter.ArgusNodeInfoTypeConverter.1
        }.getType());
    }
}
