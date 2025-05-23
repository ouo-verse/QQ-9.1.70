package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class ParamHelper {
    static IPatchRedirector $redirector_;
    private HashMap<String, ParamGenerator> mCustom;
    private BaseFilter mFilter;
    private HashMap<String, ParamInfo> mParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.filter.ParamHelper$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$filter$ParamHelper$ParamType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13622);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ParamType.values().length];
            $SwitchMap$com$tencent$filter$ParamHelper$ParamType = iArr;
            try {
                iArr[ParamType.Float.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$filter$ParamHelper$ParamType[ParamType.Int.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$filter$ParamHelper$ParamType[ParamType.Floats.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$filter$ParamHelper$ParamType[ParamType.Int1s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface ParamGenerator {
        UniformParam gen(String str);
    }

    /* loaded from: classes6.dex */
    public class ParamInfo {
        static IPatchRedirector $redirector_;
        private final String name;
        private final ParamType type;

        public ParamInfo(String str, ParamType paramType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ParamHelper.this, str, paramType);
            } else {
                this.name = str;
                this.type = paramType;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class ParamType {
        private static final /* synthetic */ ParamType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ParamType Float;
        public static final ParamType Floats;
        public static final ParamType Int;
        public static final ParamType Int1s;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13642);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ParamType paramType = new ParamType("Float", 0);
            Float = paramType;
            ParamType paramType2 = new ParamType("Int", 1);
            Int = paramType2;
            ParamType paramType3 = new ParamType("Floats", 2);
            Floats = paramType3;
            ParamType paramType4 = new ParamType("Int1s", 3);
            Int1s = paramType4;
            $VALUES = new ParamType[]{paramType, paramType2, paramType3, paramType4};
        }

        ParamType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ParamType valueOf(String str) {
            return (ParamType) Enum.valueOf(ParamType.class, str);
        }

        public static ParamType[] values() {
            return (ParamType[]) $VALUES.clone();
        }
    }

    public ParamHelper(BaseFilter baseFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseFilter);
            return;
        }
        this.mParams = new HashMap<>();
        this.mCustom = new HashMap<>();
        this.mFilter = baseFilter;
    }

    public ParamHelper addCustom(String str, ParamGenerator paramGenerator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ParamHelper) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) paramGenerator);
        }
        this.mCustom.put(str, paramGenerator);
        return this;
    }

    public ParamHelper addParam(String str, ParamType paramType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? addParam(str, str, paramType) : (ParamHelper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) paramType);
    }

    public void processParams(HashMap<String, String> hashMap) {
        ParamInfo paramInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) hashMap);
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (this.mCustom.keySet().contains(entry.getKey())) {
                ParamGenerator paramGenerator = this.mCustom.get(entry.getKey());
                if (paramGenerator != null) {
                    this.mFilter.addParam(paramGenerator.gen(entry.getKey()));
                }
            } else if (this.mParams.keySet().contains(entry.getKey()) && (paramInfo = this.mParams.get(entry.getKey())) != null) {
                int i3 = AnonymousClass1.$SwitchMap$com$tencent$filter$ParamHelper$ParamType[paramInfo.type.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        int i16 = 0;
                        if (i3 != 3) {
                            if (i3 == 4) {
                                String[] split = entry.getValue().split(",");
                                int[] iArr = new int[split.length];
                                while (i16 < split.length) {
                                    iArr[i16] = Integer.parseInt(split[i16]);
                                    i16++;
                                }
                                this.mFilter.addParam(new UniformParam.Int1sParam(paramInfo.name, iArr));
                            }
                        } else {
                            String[] split2 = entry.getValue().split(",");
                            float[] fArr = new float[split2.length];
                            while (i16 < split2.length) {
                                fArr[i16] = Float.parseFloat(split2[i16]);
                                i16++;
                            }
                            this.mFilter.addParam(new UniformParam.FloatsParam(paramInfo.name, fArr));
                        }
                    } else {
                        this.mFilter.addParam(new UniformParam.IntParam(paramInfo.name, Integer.parseInt(entry.getValue())));
                    }
                } else {
                    this.mFilter.addParam(new UniformParam.FloatParam(paramInfo.name, Float.parseFloat(entry.getValue())));
                }
            }
        }
    }

    public ParamHelper addParam(String str, String str2, ParamType paramType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ParamHelper) iPatchRedirector.redirect((short) 3, this, str, str2, paramType);
        }
        this.mParams.put(str, new ParamInfo(str2, paramType));
        return this;
    }

    public ParamHelper addParam(ArrayList<String> arrayList, ParamType paramType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ParamHelper) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList, (Object) paramType);
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.mParams.put(next, new ParamInfo(next, paramType));
        }
        return this;
    }
}
