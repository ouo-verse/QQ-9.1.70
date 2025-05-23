package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ItemType {
    public static final int ANNOTATION_DIRECTORY_ITEM = 8198;
    public static final int ANNOTATION_ITEM = 8196;
    public static final int ANNOTATION_SET_ITEM = 4099;
    public static final int ANNOTATION_SET_REF_LIST = 4098;
    public static final int CALL_SITE_ID_ITEM = 7;
    public static final int CLASS_DATA_ITEM = 8192;
    public static final int CLASS_DEF_ITEM = 6;
    public static final int CODE_ITEM = 8193;
    public static final int DEBUG_INFO_ITEM = 8195;
    public static final int ENCODED_ARRAY_ITEM = 8197;
    public static final int FIELD_ID_ITEM = 4;
    public static final int HEADER_ITEM = 0;
    public static final int HIDDENAPI_CLASS_DATA_ITEM = 61440;
    public static final int MAP_LIST = 4096;
    public static final int METHOD_HANDLE_ITEM = 8;
    public static final int METHOD_ID_ITEM = 5;
    public static final int PROTO_ID_ITEM = 3;
    public static final int STRING_DATA_ITEM = 8194;
    public static final int STRING_ID_ITEM = 1;
    public static final int TYPE_ID_ITEM = 2;
    public static final int TYPE_LIST = 4097;

    @Nonnull
    public static String getItemTypeName(int i3) {
        if (i3 != 61440) {
            switch (i3) {
                case 0:
                    return "header_item";
                case 1:
                    return "string_id_item";
                case 2:
                    return "type_id_item";
                case 3:
                    return "proto_id_item";
                case 4:
                    return "field_id_item";
                case 5:
                    return "method_id_item";
                case 6:
                    return "class_def_item";
                case 7:
                    return "call_site_id_item";
                case 8:
                    return "method_handle_item";
                default:
                    switch (i3) {
                        case 4096:
                            return "map_list";
                        case 4097:
                            return "type_list";
                        case 4098:
                            return "annotation_set_ref_list";
                        case 4099:
                            return "annotation_set_item";
                        default:
                            switch (i3) {
                                case 8192:
                                    return "class_data_item";
                                case 8193:
                                    return "code_item";
                                case 8194:
                                    return "string_data_item";
                                case 8195:
                                    return "debug_info_item";
                                case 8196:
                                    return "annotation_item";
                                case 8197:
                                    return "encoded_array_item";
                                case 8198:
                                    return "annotation_directory_item";
                                default:
                                    return "unknown dex item type";
                            }
                    }
            }
        }
        return "hiddenapi_class_data_item";
    }
}
