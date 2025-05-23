package org.light.lightAssetKit.components;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.light.LightConstants;
import org.light.datasource.LightDataSource;
import org.light.datasource.LightDateDataSourceValue;
import org.light.datasource.LightLocationDataSourceValue;
import org.light.datasource.LightUserInfoDataSourceValue;
import org.light.datasource.LightWatermarkDataSourceDescription;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DataSourceComponent extends Component {
    protected static Gson __gson;
    private HashMap<String, LightDataSource> data;

    public static Gson gson() {
        if (__gson == null) {
            __gson = new GsonBuilder().registerTypeHierarchyAdapter(DataSourceComponent.class, new JsonDeserializer<DataSourceComponent>() { // from class: org.light.lightAssetKit.components.DataSourceComponent.1
                @Override // com.google.gson.JsonDeserializer
                public DataSourceComponent deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    DataSourceComponent dataSourceComponent = new DataSourceComponent();
                    dataSourceComponent.setData(DataSourceComponent.makeDataWithDifferentKey(asJsonObject));
                    return dataSourceComponent;
                }
            }).create();
        }
        return __gson;
    }

    private static LightDataSource makeDataSourceAndSetDesc(JsonObject jsonObject) {
        LightDataSource lightDataSource = new LightDataSource();
        lightDataSource.setEntityId(jsonObject.get(TemplateParser.KEY_ENTITY_ID).getAsLong());
        lightDataSource.setDataKey(jsonObject.get("key").getAsString());
        lightDataSource.setDesc(LightWatermarkDataSourceDescription.makeFromJson(jsonObject.getAsJsonObject("desc")));
        return lightDataSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, LightDataSource> makeDataWithDifferentKey(JsonObject jsonObject) {
        HashMap<String, LightDataSource> hashMap = new HashMap<>();
        JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
        if (asJsonObject.has(LightConstants.DataSourceKey.DATE)) {
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject(LightConstants.DataSourceKey.DATE);
            LightDataSource makeDataSourceAndSetDesc = makeDataSourceAndSetDesc(asJsonObject2);
            JsonObject asJsonObject3 = asJsonObject2.getAsJsonObject("value");
            if (asJsonObject3 != null) {
                LightDateDataSourceValue lightDateDataSourceValue = new LightDateDataSourceValue();
                lightDateDataSourceValue.setTimestamp(asJsonObject3.get("timestamp").getAsLong());
                makeDataSourceAndSetDesc.setValue(lightDateDataSourceValue);
            }
            hashMap.put(LightConstants.DataSourceKey.DATE, makeDataSourceAndSetDesc);
        }
        if (asJsonObject.has(LightConstants.DataSourceKey.LOCATION)) {
            JsonObject asJsonObject4 = asJsonObject.getAsJsonObject(LightConstants.DataSourceKey.LOCATION);
            LightDataSource makeDataSourceAndSetDesc2 = makeDataSourceAndSetDesc(asJsonObject4);
            JsonObject asJsonObject5 = asJsonObject4.getAsJsonObject("value");
            if (asJsonObject5 != null) {
                LightLocationDataSourceValue lightLocationDataSourceValue = new LightLocationDataSourceValue();
                lightLocationDataSourceValue.setCity(asJsonObject5.get("city").getAsString());
                lightLocationDataSourceValue.setAddress(asJsonObject5.get("address").getAsString());
                lightLocationDataSourceValue.setCountry(asJsonObject5.get("country").getAsString());
                lightLocationDataSourceValue.setDisplayName(asJsonObject5.get(CommonConstant.KEY_DISPLAY_NAME).getAsString());
                lightLocationDataSourceValue.setDistrict(asJsonObject5.get("district").getAsString());
                lightLocationDataSourceValue.setLatitude(asJsonObject5.get("latitude").getAsString());
                lightLocationDataSourceValue.setLongitude(asJsonObject5.get("longitude").getAsString());
                lightLocationDataSourceValue.setPoiName(asJsonObject5.get("poiName").getAsString());
                lightLocationDataSourceValue.setProvince(asJsonObject5.get("province").getAsString());
                lightLocationDataSourceValue.setRoad(asJsonObject5.get("road").getAsString());
                lightLocationDataSourceValue.setTown(asJsonObject5.get("town").getAsString());
                lightLocationDataSourceValue.setVillage(asJsonObject5.get("village").getAsString());
                makeDataSourceAndSetDesc2.setValue(lightLocationDataSourceValue);
            }
            hashMap.put(LightConstants.DataSourceKey.LOCATION, makeDataSourceAndSetDesc2);
        }
        if (asJsonObject.has(LightConstants.DataSourceKey.USER_INFO)) {
            JsonObject asJsonObject6 = asJsonObject.getAsJsonObject(LightConstants.DataSourceKey.USER_INFO);
            LightDataSource makeDataSourceAndSetDesc3 = makeDataSourceAndSetDesc(asJsonObject6);
            JsonObject asJsonObject7 = asJsonObject6.getAsJsonObject("value");
            if (asJsonObject7 != null) {
                LightUserInfoDataSourceValue lightUserInfoDataSourceValue = new LightUserInfoDataSourceValue();
                lightUserInfoDataSourceValue.setNickName(asJsonObject7.get("nickName").getAsString());
                lightUserInfoDataSourceValue.setAvatarPath(asJsonObject7.get("avatarPath").getAsString());
                lightUserInfoDataSourceValue.setSettlementTimeLabel(asJsonObject7.get("settlementTimeLabel").getAsString());
                lightUserInfoDataSourceValue.setGender(asJsonObject7.get("gender").getAsString());
                lightUserInfoDataSourceValue.setLocationLabel(asJsonObject7.get("locationLabel").getAsString());
                lightUserInfoDataSourceValue.setDescribeLabel(asJsonObject7.get("describeLabel").getAsString());
                lightUserInfoDataSourceValue.setConstellationLabel(asJsonObject7.get("constellationLabel").getAsString());
                lightUserInfoDataSourceValue.setMonthLabel(asJsonObject7.get("monthLabel").getAsString());
                lightUserInfoDataSourceValue.setDayLabel(asJsonObject7.get("dayLabel").getAsString());
                lightUserInfoDataSourceValue.setAgeLabel(asJsonObject7.get("ageLabel").getAsString());
                makeDataSourceAndSetDesc3.setValue(lightUserInfoDataSourceValue);
            }
            hashMap.put(LightConstants.DataSourceKey.USER_INFO, makeDataSourceAndSetDesc3);
        }
        return hashMap;
    }

    public HashMap<String, LightDataSource> getData() {
        return this.data;
    }

    public void setData(HashMap<String, LightDataSource> hashMap) {
        this.data = hashMap;
        reportPropertyChange("data", hashMap);
    }

    @Override // org.light.lightAssetKit.ComponentBase
    public synchronized JsonObject toJsonObject() {
        JsonObject jsonObject;
        jsonObject = new JsonObject();
        jsonObject.addProperty("type", "DataSourceComponent");
        JsonObject jsonObject2 = new JsonObject();
        HashMap<String, LightDataSource> hashMap = this.data;
        if (hashMap != null) {
            for (Map.Entry<String, LightDataSource> entry : hashMap.entrySet()) {
                jsonObject2.add(entry.getKey(), entry.getValue().toJsonObject());
            }
        }
        jsonObject.add("data", jsonObject2);
        return jsonObject;
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "DataSourceComponent";
    }
}
