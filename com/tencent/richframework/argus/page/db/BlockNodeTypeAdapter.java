package com.tencent.richframework.argus.page.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tencent.richframework.argus.node.ActivityNode;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.FragmentNode;
import com.tencent.richframework.argus.node.TabHostNode;
import com.tencent.richframework.argus.node.ViewPager2Block;
import com.tencent.richframework.argus.node.ViewPagerNode;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BlockNodeTypeAdapter extends TypeAdapter<ArgusNode<?>> {
    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public ArgusNode<?> read2(JsonReader jsonReader) throws IOException {
        JsonObject jsonObject = (JsonObject) this.gson.fromJson(jsonReader, JsonObject.class);
        if (jsonObject.has("mActivityClassName")) {
            return (ArgusNode) this.gson.fromJson((JsonElement) jsonObject, ActivityNode.class);
        }
        if (jsonObject.has("mFragmentId")) {
            return (ArgusNode) this.gson.fromJson((JsonElement) jsonObject, FragmentNode.class);
        }
        return (ArgusNode) this.gson.fromJson((JsonElement) jsonObject, ArgusNode.class);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ArgusNode<?> argusNode) throws IOException {
        if (argusNode instanceof ActivityNode) {
            this.gson.toJson(argusNode, ActivityNode.class, jsonWriter);
            return;
        }
        if (argusNode instanceof FragmentNode) {
            this.gson.toJson(argusNode, FragmentNode.class, jsonWriter);
            return;
        }
        if (argusNode instanceof TabHostNode) {
            this.gson.toJson(argusNode, TabHostNode.class, jsonWriter);
            return;
        }
        if (argusNode instanceof ViewPager2Block) {
            this.gson.toJson(argusNode, ArgusNode.class, jsonWriter);
        } else if (argusNode instanceof ViewPagerNode) {
            this.gson.toJson(argusNode, ViewPagerNode.class, jsonWriter);
        } else {
            this.gson.toJson(argusNode, ArgusNode.class, jsonWriter);
        }
    }
}
