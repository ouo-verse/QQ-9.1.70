package jn1;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b {

    @SerializedName("jsonFeed")
    public String jsonFeed;

    @SerializedName("taskIds")
    public List<String> taskIds;

    public String toString() {
        return "GuildPublishJSBean{taskIds=" + this.taskIds + ", jsonFeed='" + this.jsonFeed + "'}";
    }
}
