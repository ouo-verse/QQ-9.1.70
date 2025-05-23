package org.jf.dexlib2;

import com.google.common.collect.Maps;
import com.google.common.collect.z;
import java.util.EnumMap;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Opcodes {
    public final int api;
    public final int artVersion;

    @Nonnull
    private final EnumMap<Opcode, Short> opcodeValues;

    @Nonnull
    private final HashMap<String, Opcode> opcodesByName;

    @Nonnull
    private final Opcode[] opcodesByValue = new Opcode[256];

    Opcodes(int i3, int i16) {
        int i17;
        z<Integer, Short> zVar;
        if (i3 >= 21) {
            this.api = i3;
            this.artVersion = VersionMap.mapApiToArtVersion(i3);
        } else if (i16 >= 0 && i16 < 39) {
            this.api = VersionMap.mapArtVersionToApi(i16);
            this.artVersion = i16;
        } else {
            this.api = i3;
            this.artVersion = i16;
        }
        this.opcodeValues = new EnumMap<>(Opcode.class);
        this.opcodesByName = Maps.j();
        if (isArt()) {
            i17 = this.artVersion;
        } else {
            i17 = this.api;
        }
        for (Opcode opcode : Opcode.values()) {
            if (isArt()) {
                zVar = opcode.artVersionToValueMap;
            } else {
                zVar = opcode.apiToValueMap;
            }
            Short sh5 = zVar.get(Integer.valueOf(i17));
            if (sh5 != null) {
                if (!opcode.format.isPayloadFormat) {
                    this.opcodesByValue[sh5.shortValue()] = opcode;
                }
                this.opcodeValues.put((EnumMap<Opcode, Short>) opcode, (Opcode) sh5);
                this.opcodesByName.put(opcode.name.toLowerCase(), opcode);
            }
        }
    }

    @Nonnull
    public static Opcodes forApi(int i3) {
        return new Opcodes(i3, -1);
    }

    @Nonnull
    public static Opcodes forArtVersion(int i3) {
        return new Opcodes(-1, i3);
    }

    @Nonnull
    public static Opcodes forDexVersion(int i3) {
        int mapDexVersionToApi = VersionMap.mapDexVersionToApi(i3);
        if (mapDexVersionToApi != -1) {
            return new Opcodes(mapDexVersionToApi, -1);
        }
        throw new RuntimeException("Unsupported dex version " + i3);
    }

    @Nonnull
    public static Opcodes getDefault() {
        return forApi(20);
    }

    @Nullable
    public Opcode getOpcodeByName(@Nonnull String str) {
        return this.opcodesByName.get(str.toLowerCase());
    }

    @Nullable
    public Opcode getOpcodeByValue(int i3) {
        if (i3 != 256) {
            if (i3 != 512) {
                if (i3 != 768) {
                    if (i3 >= 0) {
                        Opcode[] opcodeArr = this.opcodesByValue;
                        if (i3 < opcodeArr.length) {
                            return opcodeArr[i3];
                        }
                        return null;
                    }
                    return null;
                }
                return Opcode.ARRAY_PAYLOAD;
            }
            return Opcode.SPARSE_SWITCH_PAYLOAD;
        }
        return Opcode.PACKED_SWITCH_PAYLOAD;
    }

    @Nullable
    public Short getOpcodeValue(@Nonnull Opcode opcode) {
        return this.opcodeValues.get(opcode);
    }

    public boolean isArt() {
        if (this.artVersion != -1) {
            return true;
        }
        return false;
    }
}
