package cooperation.qzone.statistic.access.concept;

import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class Assembler {
    public static Assembler Array = new Assembler() { // from class: cooperation.qzone.statistic.access.concept.Assembler.1
        @Override // cooperation.qzone.statistic.access.concept.Assembler
        public String assemble(List<Statistic> list) {
            Key[] keys = list.get(0).getKeys();
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                Statistic statistic = list.get(i3);
                for (Key key : keys) {
                    sb5.append(key);
                    sb5.append("\u2192");
                    sb5.append(statistic.getValue(key));
                    sb5.append(",");
                }
                sb5.append("\n");
            }
            return sb5.toString();
        }
    };

    public abstract String assemble(List<Statistic> list);
}
