package o4;

import com.qzone.album.data.model.TimeLine;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {
    public static HashMap<Integer, HashMap<Integer, ArrayList<TimeLine>>> a(ArrayList<TimeLine> arrayList) {
        if (arrayList == null) {
            return null;
        }
        HashMap<Integer, HashMap<Integer, ArrayList<TimeLine>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            TimeLine timeLine = arrayList.get(i3);
            if (timeLine != null && timeLine.showTime >= 0) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(timeLine.beginTime * 1000);
                int i16 = calendar.get(1);
                int i17 = calendar.get(2) + 1;
                if (!hashMap.containsKey(Integer.valueOf(i16))) {
                    HashMap<Integer, ArrayList<TimeLine>> hashMap2 = new HashMap<>();
                    ArrayList<TimeLine> arrayList2 = new ArrayList<>();
                    arrayList2.add(timeLine);
                    hashMap2.put(Integer.valueOf(i17), arrayList2);
                    hashMap.put(Integer.valueOf(i16), hashMap2);
                } else {
                    HashMap<Integer, ArrayList<TimeLine>> hashMap3 = hashMap.get(Integer.valueOf(i16));
                    if (!hashMap3.containsKey(Integer.valueOf(i17))) {
                        ArrayList<TimeLine> arrayList3 = new ArrayList<>();
                        arrayList3.add(timeLine);
                        hashMap3.put(Integer.valueOf(i17), arrayList3);
                    } else {
                        hashMap3.get(Integer.valueOf(i17)).add(timeLine);
                    }
                }
            }
        }
        return hashMap;
    }
}
