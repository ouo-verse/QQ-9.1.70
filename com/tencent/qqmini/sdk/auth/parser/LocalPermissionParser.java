package com.tencent.qqmini.sdk.auth.parser;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.Log;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.auth.EventInfo;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes23.dex */
public final class LocalPermissionParser extends AbstractPermissionParser {
    private static final int PERMISSION_XML = R.xml.mini_sdk_permissions;
    private Context mContext;

    public LocalPermissionParser(Context context) {
        this.mContext = context;
    }

    private void appendRequestPermission(EventInfo eventInfo, String str) {
        if (eventInfo != null && str != null) {
            if (eventInfo.requestPermissions == null) {
                eventInfo.requestPermissions = new ArrayList();
            }
            eventInfo.requestPermissions.add(str);
        }
    }

    private void doParse() throws XmlPullParserException, IOException {
        clear();
        XmlResourceParser xml = this.mContext.getResources().getXml(PERMISSION_XML);
        PermissionInfo permissionInfo = null;
        EventInfo eventInfo = null;
        String str = null;
        while (xml.getEventType() != 1) {
            String name = xml.getName();
            int eventType = xml.getEventType();
            if (eventType != 2) {
                if (eventType == 3) {
                    if (QCircleDaTongConstant.ElementParamValue.PERMISSION.equals(name)) {
                        addPermission(permissionInfo);
                    } else if ("event".equals(name)) {
                        addEvent(eventInfo);
                    } else if ("request-permission".equals(name)) {
                        appendRequestPermission(eventInfo, str);
                    }
                }
            } else if (QCircleDaTongConstant.ElementParamValue.PERMISSION.equals(name)) {
                permissionInfo = parsePermission(xml);
            } else if ("event".equals(name)) {
                eventInfo = parseEvent(xml);
            } else if ("request-permission".equals(name)) {
                str = parseRequestPermission(xml);
            }
            xml.next();
        }
    }

    private String getStringByAttribute(String str) {
        if (!StringUtil.isEmpty(str) && '@' == str.charAt(0)) {
            String substring = str.substring(1);
            if (isNumeric(substring)) {
                return this.mContext.getString(Integer.parseInt(substring));
            }
            return substring;
        }
        return str;
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+(\\.\\d+)?");
    }

    private EventInfo parseEvent(XmlPullParser xmlPullParser) {
        try {
            EventInfo eventInfo = new EventInfo();
            for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
                String attributeName = xmlPullParser.getAttributeName(i3);
                String attributeValue = xmlPullParser.getAttributeValue(i3);
                if ("name".equals(attributeName)) {
                    eventInfo.name = attributeValue;
                }
            }
            return eventInfo;
        } catch (Exception e16) {
            QMLog.e(AbstractPermissionParser.TAG, e16.getMessage(), e16);
            return null;
        }
    }

    private PermissionInfo parsePermission(XmlPullParser xmlPullParser) {
        int i3;
        try {
            PermissionInfo permissionInfo = new PermissionInfo();
            for (int i16 = 0; i16 < xmlPullParser.getAttributeCount(); i16++) {
                String attributeName = xmlPullParser.getAttributeName(i16);
                String attributeValue = xmlPullParser.getAttributeValue(i16);
                if ("id".equals(attributeName)) {
                    permissionInfo.f348015id = attributeValue;
                } else if ("name".equals(attributeName)) {
                    permissionInfo.name = getStringByAttribute(attributeValue);
                } else if ("description".equals(attributeName)) {
                    permissionInfo.description = getStringByAttribute(attributeValue);
                } else if ("description-reject".equals(attributeName)) {
                    permissionInfo.rejectDescription = getStringByAttribute(attributeValue);
                } else if ("built-in".equals(attributeName)) {
                    permissionInfo.builtIn = Boolean.parseBoolean(attributeValue);
                } else if ("min-sdk-version".equals(attributeName)) {
                    if (isNumeric(attributeValue)) {
                        i3 = Integer.parseInt(attributeValue);
                    } else {
                        i3 = 1;
                    }
                    if (Build.VERSION.SDK_INT < i3) {
                        Log.i(AbstractPermissionParser.TAG, "Ignore permission " + permissionInfo + ". Required min-sdk-version is " + i3);
                        return null;
                    }
                } else if ("report_sub_action".endsWith(attributeName)) {
                    permissionInfo.reportSubAction = getStringByAttribute(attributeValue);
                }
            }
            if (StringUtil.isEmpty(permissionInfo.rejectDescription)) {
                permissionInfo.rejectDescription = this.mContext.getString(R.string.mini_sdk_perm_desc_default_reject);
            }
            return permissionInfo;
        } catch (Exception e16) {
            QMLog.e(AbstractPermissionParser.TAG, e16.getMessage(), e16);
            return null;
        }
    }

    private String parseRequestPermission(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (xmlPullParser.next() == 4) {
            return xmlPullParser.getText();
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.auth.parser.AbstractPermissionParser
    public /* bridge */ /* synthetic */ boolean addEvent(EventInfo eventInfo) {
        return super.addEvent(eventInfo);
    }

    @Override // com.tencent.qqmini.sdk.auth.parser.AbstractPermissionParser
    public /* bridge */ /* synthetic */ boolean addPermission(PermissionInfo permissionInfo) {
        return super.addPermission(permissionInfo);
    }

    @Override // com.tencent.qqmini.sdk.auth.parser.AbstractPermissionParser
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.tencent.qqmini.sdk.auth.parser.AbstractPermissionParser, com.tencent.qqmini.sdk.auth.PermissionParser
    public /* bridge */ /* synthetic */ Map getEventsMap() {
        return super.getEventsMap();
    }

    @Override // com.tencent.qqmini.sdk.auth.parser.AbstractPermissionParser, com.tencent.qqmini.sdk.auth.PermissionParser
    public /* bridge */ /* synthetic */ Map getScopePermissionMap() {
        return super.getScopePermissionMap();
    }

    @Override // com.tencent.qqmini.sdk.auth.parser.AbstractPermissionParser, com.tencent.qqmini.sdk.auth.PermissionParser
    public /* bridge */ /* synthetic */ Map getSystemPermissionMap() {
        return super.getSystemPermissionMap();
    }

    @Override // com.tencent.qqmini.sdk.auth.PermissionParser
    public boolean parse() {
        try {
            doParse();
            return true;
        } catch (IOException e16) {
            QMLog.e(AbstractPermissionParser.TAG, e16.getMessage(), e16);
            return false;
        } catch (XmlPullParserException e17) {
            QMLog.e(AbstractPermissionParser.TAG, e17.getMessage(), e17);
            return false;
        } catch (Exception e18) {
            QMLog.e(AbstractPermissionParser.TAG, e18.getMessage(), e18);
            return false;
        }
    }
}
