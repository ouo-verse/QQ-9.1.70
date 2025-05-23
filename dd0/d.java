package dd0;

import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct$POIPosterData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends com.tencent.biz.qqstory.channel.a {

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<bd0.a> f393630c = new ArrayList<>();

    public d(qqstory_service$RspGetPOIPosters qqstory_service_rspgetpoiposters) {
        a(qqstory_service_rspgetpoiposters);
    }

    private void a(qqstory_service$RspGetPOIPosters qqstory_service_rspgetpoiposters) {
        for (int i3 = 0; i3 < qqstory_service_rspgetpoiposters.poi_posters.size(); i3++) {
            qqstory_struct$POIPosterData qqstory_struct_poiposterdata = qqstory_service_rspgetpoiposters.poi_posters.get(i3);
            this.f393630c.add(new bd0.a(qqstory_struct_poiposterdata.poster_name.get().toStringUtf8(), qqstory_struct_poiposterdata.name.get().toStringUtf8(), qqstory_struct_poiposterdata.thumb_url.get().toStringUtf8(), qqstory_struct_poiposterdata.poster_url.get().toStringUtf8(), qqstory_struct_poiposterdata.poster_json_layout_desc.get().toStringUtf8()));
        }
    }
}
